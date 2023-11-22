package frame;

import java.io.IOException;

import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public abstract class Service {
	public abstract void execute(RequestContext req,ResponseContext res) throws IOException,ResourceException,BadRequestException,NotFoundException;
}
