package quizoo.setter.ajax;

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
        
    	int user_no = req.getUser().getUserNo();
    	
    	Gson gson = new Gson();
        QuizQuestionBean quizQuestionBean = gson.fromJson(req.getMessageBody(), QuizQuestionBean.class);


        QuizQuestionDao quizQuestionDao = new QuizQuestionDao();
        quizQuestionDao.insertQuizQuestion(user_no,quizQuestionBean);
    }
}
