package frame.context;

import java.io.PrintWriter;

public interface ResponseContext {
    public void forward(String url, RequestContext requestContext);
    public PrintWriter getWrite();
}
