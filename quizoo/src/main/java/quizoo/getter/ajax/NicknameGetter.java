package quizoo.getter.ajax;

import java.io.IOException;

import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class NicknameGetter extends Service {
	
	@Override
	public void execute(RequestContext req, ResponseContext res)
			throws IOException, ResourceException, BadRequestException, NotFoundException {
		
	}
}
