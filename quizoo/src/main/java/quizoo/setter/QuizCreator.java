package quizoo.setter;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import db.bean.QuestionBean;
import db.bean.QuizBean;
import db.dao.QuizDao;
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
        
        
        JsonObject jsonObject = gson.fromJson(req.getMessageBody(), JsonObject.class);

        JsonObject quizJson = jsonObject.getAsJsonObject("quiz");
        QuizBean quizBean = gson.fromJson(quizJson, QuizBean.class);

        JsonObject questionJson = jsonObject.getAsJsonObject("question");
        QuestionBean questionBean = gson.fromJson(questionJson, QuestionBean.class);

        // JSONからQuizBeanに変換
        quizBean = gson.fromJson(req.getMessageBody(), QuizBean.class);
        // JSONからQuestionBeanに変換
        questionBean = gson.fromJson(req.getMessageBody(), QuestionBean.class);
        
        
        QuizDao quizDao = new QuizDao();
        QuizQuestionDao quizQuestionDao = new QuizQuestionDao();
        

        quizDao.insertQuiz(quizBean);
        quizQuestionDao.insertQuestion(questionBean);
        
    }

}
