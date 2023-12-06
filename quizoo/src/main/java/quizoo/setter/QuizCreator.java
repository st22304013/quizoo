package quizoo.setter;

import java.io.IOException;

import com.google.gson.Gson;

import db.bean.QuizQuestionBean;
import db.dao.QuizQuestionDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class QuizCreator extends Service {

    @Override
    public void execute(RequestContext req, ResponseContext res)
            throws IOException, ResourceException, BadRequestException, NotFoundException {
        
    	Gson gson = new Gson();
        QuizQuestionBean quizQuestionBean = gson.fromJson(req.getMessageBody(), QuizQuestionBean.class);

//        QuizBean quizBean = quizQuestionBean.getQuiz();
//        
//        QuizDao quizDao = new QuizDao();
//        quizDao.insertQuiz(quizBean);

        QuizQuestionDao quizQuestionDao = new QuizQuestionDao();
        quizQuestionDao.insertQuizQuestion(quizQuestionBean);
    }
}
