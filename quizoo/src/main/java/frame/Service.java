package frame;

import frame.context.RequestContext;
import frame.context.ResponseContext;

public abstract class Service {
	public abstract void execute(RequestContext req,ResponseContext res);
}
