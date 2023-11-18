package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.ServiceFactory;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;
import web.context.HttpRequestContext;

public class FrontServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ServiceFactory.getService(req.getServletContext().getResourceAsStream("WEB-INF/command-mapping.properties"),new HttpRequestContext(req));
		} catch (ResourceException | NotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
} 

