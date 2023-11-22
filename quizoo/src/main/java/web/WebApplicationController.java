package web;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.ApplicationController;
import frame.Service;
import frame.ServiceFactory;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;
import web.context.HttpRequestContext;
import web.context.HttpResponseContext;

public class WebApplicationController implements ApplicationController{

	@Override
	public RequestContext getRequest(Object request) {
		return new HttpRequestContext((HttpServletRequest)request);
	}

	@Override
	public ResponseContext getResponse(Object response) {
		return new HttpResponseContext((HttpServletResponse)response);
	}

	@Override
	public void handleResponse(RequestContext request, ResponseContext response) throws ResourceException, NotFoundException {
		HttpServletRequest hreq = ((HttpRequestContext)request).getRequest();
		
		InputStream stream = hreq.getServletContext().getResourceAsStream("WEB-INF/command-mapping.properties");
		
		Service service = ServiceFactory.getService(stream, request);
		
		
		
	}
} 
