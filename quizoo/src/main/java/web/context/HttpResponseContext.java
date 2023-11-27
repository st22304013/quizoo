package web.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;

public class HttpResponseContext implements ResponseContext{
	
	HttpServletResponse res = null;
	
	public HttpResponseContext(HttpServletResponse res) {
		this.res = res;
	}
	
	public HttpServletResponse getResponse() {
		return res;
	}
	
	@Override
	public void forward(String url, RequestContext req) throws BadRequestException {
		HttpServletRequest sreq = ((HttpRequestContext)req).getRequest();
		
		try {
			sreq.getRequestDispatcher(url).forward(sreq,res);
		} catch (ServletException | IOException e) {
			throw new BadRequestException(e.getMessage(), e);
		}
		
	}

	@Override
	public PrintWriter getWrite() throws IOException {
		return res.getWriter();
	}

	@Override
	public void redirect(String url) throws IOException {
		res.sendRedirect(url);
		
	}
	
	
	
	
} 