package quizoo;

import java.io.IOException;

import db.bean.UserInfoBean;
import db.dao.UserInfoDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.ResourceException;

public class Login extends Service{

	@Override
	public void execute(RequestContext req, ResponseContext res) 
			throws IOException, ResourceException,BadRequestException {
		String userId = req.getParameter("user_id")[0];
		String pass = req.getParameter("password")[0];
		
		//userIdのチェック
		if(userId == null || userId.isEmpty()) {
			throw new BadRequestException("userIdが空");
		}
		
		//passwordのチェック
		if(pass == null || pass.isEmpty()) {
			throw new BadRequestException("passwordが空");
		}
		
		UserInfoDao dao = new UserInfoDao();
		UserInfoBean bean = dao.selectUser(userId);
		
		//passwordが一致したとき
		if(pass.equals(bean.getPassword())) {
			req.setUser(bean);
			res.redirect("index");
		}else {
			res.redirect("login-page?faild");
		}
		
	}
}
