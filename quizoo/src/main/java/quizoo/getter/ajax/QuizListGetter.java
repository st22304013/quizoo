package quizoo.getter.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import db.dao.QuizDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.ResourceException;

public class QuizListGetter extends Service {

	private static HashMap<String, String> paramColMap = new HashMap<String, String>();
	static {
		paramColMap.put("new", "create_time");
		paramColMap.put("ganle", "genre_no");
	}
	@Override
	public void execute(RequestContext req, ResponseContext res) throws IOException, ResourceException {
		
		String order = req.getParameter("order")[0];
		
		order = paramColMap.get(order);
		
		System.out.println(order);
		
		PrintWriter out = res.getWrite();
		
		QuizDao quizDao = new QuizDao();
		ArrayList quizList = quizDao.selectOrderedQuiz(order);
		Gson gson = new Gson();
		String result = gson.toJson(quizList);
		
		out.println(result);
	}

}
