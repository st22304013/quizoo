package quizoo.setter;

import java.io.IOException;

import com.google.gson.Gson;

import db.bean.QuestionBeanForJSON;
import db.bean.QuizBeanForJSON;
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
        
    	// JSONからQuizBeanForJSONに変換
	    String jsonString = "{   \n"
	            + "    \"quizId\": 11,\n"
	            + "    \"authorNo\": 123,\n"
	            + "    \"title\": \"Sample Quiz\",\n"
	            + "    \"questionCount\": 5,\n"
	            + "    \"genreNo\":1,\n"
	            + "    \"explanation\": \"Sample Explanation\",\n"
	            + "    \"createTime\": \"2023-12-04\",\n"
	            + "    \"correctRate\": 0.0,\n"
	            + "    \"totalParticipants\": 0,\n"
	            + "    \"questions\":[\n"
	            + "        {\n"
	            + "            \"quizId\": 10,\n"
	            + "            \"question\": \"問題文１\",\n"
	            + "            \"choice1\": \"回答１\",\n"
	            + "            \"choice2\": \"正解\",\n"
	            + "            \"choice3\": \"回答２\",\n"
	            + "            \"choice4\": \"回答３\",\n"
	            + "            \"judge\": [false, true, false, false]\n"
	            + "        },\n"
	            + "        {\n"
	            + "            \"quizId\": 10,\n"
	            + "            \"question\": \"問題文２\",\n"
	            + "            \"choice1\": \"回答１\",\n"
	            + "            \"choice2\": \"正解２\",\n"
	            + "            \"choice3\": \"回答２\",\n"
	            + "            \"choice4\": \"回答３\",\n"
	            + "            \"judge\": [true, false, false, false]\n"
	            + "        }\n"
	            + "    ]\n"
	            + "}";; // 与えられたJSONデータを文字列として設定する
    	
    	Gson gson = new Gson();
    	QuizBeanForJSON quizBean = gson.fromJson(jsonString, QuizBeanForJSON.class);
    	// 変換されたオブジェクトをコンソールに出力
    	System.out.println("QuizBeanForJSON: " + quizBean);
    	
//        Gson gson = new Gson();
//        String requestBody = req.getMessageBody();
//        
//        // JSONからQuizBeanForJSONに変換
//        QuizBeanForJSON quizBean = gson.fromJson(requestBody, QuizBeanForJSON.class);
        
    	// QuizBeanForJSONをQuizDaoに挿入
    	QuizDao quizDao = new QuizDao();
    	quizDao.insertQuiz(quizBean);

    	// クイズの質問をQuizQuestionDaoに挿入
    	if (quizBean.getQuestions() != null) {
    	    QuizQuestionDao quizQuestionDao = new QuizQuestionDao();
    	    for (QuestionBeanForJSON question : quizBean.getQuestions()) {
    	        quizQuestionDao.insertQuestion(question);
    	    }
    	}
    }
}
