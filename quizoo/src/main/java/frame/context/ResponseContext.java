package frame.context;

import java.io.PrintWriter;

public interface ResponseContext {
    void forward(String url, RequestContext requestContext);
    PrintWriter getWrite();
}
