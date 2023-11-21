package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;
import web.util.MethodChecker;

public class FrontServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(MethodChecker.check(req));
		
		WebApplicationController controller = new WebApplicationController();
		
		RequestContext reqc = controller.getRequest(req);
		ResponseContext resc = controller.getResponse(resp);
		
		try {
			controller.handleResponse(reqc, resc);
		} catch (ResourceException | NotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
}
