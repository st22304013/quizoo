package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.Service;
import frame.ServiceFactory;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;
import web.context.HttpRequestContext;
import web.context.HttpResponseContext;

public class FrontServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Service service =  ServiceFactory.getService(req.getServletContext().getResourceAsStream("WEB-INF/command-mapping.properties"),new HttpRequestContext(req));
			HttpRequestContext reqc = new HttpRequestContext(req);
			HttpResponseContext resc = new HttpResponseContext(resp);
			service.execute(reqc, resc);
		} catch (ResourceException | NotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
} 

