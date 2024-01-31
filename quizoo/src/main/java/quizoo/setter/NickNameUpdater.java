package quizoo.setter;

import java.io.IOException;

import com.google.gson.Gson;

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
        
    	try {
    		
    		UserInfoBean user = req.getUser();
    		Gson gson = new Gson();
    		String body = req.getMessageBody();
    		
    		Nickname name = gson.fromJson(body, Nickname.class);
    		
    		UserInfoDao userinfoDao = new UserInfoDao();
    		userinfoDao.updateNickName(user.getUserNo(), name.getNickname());
    	}catch(Throwable e) {
    		e.printStackTrace();
    	}

    }
    
    private class Nickname{
    	private String nickname;

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
    	
    }
}
