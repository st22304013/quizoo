package quizoo.setter;

import java.io.IOException;

import db.dao.UserInfoDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class ChangePassword extends Service {

    @Override
    public void execute(RequestContext req, ResponseContext res)
            throws IOException, ResourceException, BadRequestException, NotFoundException {
        String password = req.getParameter("password")[0];
        String userId = req.getUser().getUserId();
        
        UserInfoDao dao = new UserInfoDao();
        dao.updatePassword(userId,password);
    	
    }
}
