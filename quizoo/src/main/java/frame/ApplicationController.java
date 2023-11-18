package frame;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public interface ApplicationController {
    public RequestContext getRequest(Object request);
    ResponseContext getResponse(Object response);
    public void handleResponse(RequestContext request, ResponseContext response) throws ResourceException, NotFoundException;
}
