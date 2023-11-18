package frame.context;

import java.io.IOException;
import java.io.PrintWriter;

import frame.exception.BadRequestException;

public interface ResponseContext {
    public void forward(String url, RequestContext requestContext) throws BadRequestException;
    public PrintWriter getWrite() throws IOException;
}
