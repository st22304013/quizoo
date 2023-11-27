package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class FrontServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		WebApplicationController controller = new WebApplicationController();
		
		RequestContext reqc = controller.getRequest(req);
		ResponseContext resc = controller.getResponse(resp);
//		if(!MethodChecker.check(req)) {
//			resp.sendError(405);
//			return;
//		}
		
		try {
			controller.handleResponse(reqc, resc);
		} catch (ResourceException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NotFoundException e) {
			resp.sendError(404);
			e.printStackTrace();
		} catch (BadRequestException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	
}
