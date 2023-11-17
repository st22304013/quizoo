package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.dao.ConcreteDao;
import frame.exception.ResourceException;

public class FrontServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConcreteDao dao = new ConcreteDao();
		try {
			dao.select();
		} catch (ResourceException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
} 

