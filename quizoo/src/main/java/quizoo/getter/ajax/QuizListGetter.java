package quizoo.getter.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import db.bean.QuizBean;
import db.dao.QuizDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;

public class QuizListGetter extends Service {

	@Override
	public void execute(RequestContext req, ResponseContext res) throws IOException {
		
		PrintWriter out = res.getWrite();
		
		
		
		QuizBean qBean = new QuizBean();
		QuizDao qdao = new QuizDao();
		qBean = qdao.selectQuiz();//quiz_idはrequestContextからとってきてby和希
		Gson gson = new Gson();
		String result = gson.toJson(qBean);
		
		
	}

}
