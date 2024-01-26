package quizoo.setter;

import java.io.IOException;

import db.bean.UserInfoBean;
import db.dao.UserInfoDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class NickNameUpdater extends Service {

    @Override
    public void execute(RequestContext req, ResponseContext res)
            throws IOException, ResourceException, BadRequestException, NotFoundException {
        

    	UserInfoBean user = req.getUser();
    	String[] nickName = req.getParameter("nickname");

        UserInfoDao userinfoDao = new UserInfoDao();
        userinfoDao.updateNickName(user.getUserNo(), nickName[0]);
    }
}
