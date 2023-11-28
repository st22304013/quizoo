package quizoo;

import java.io.IOException;

import db.bean.UserInfoBean;
import db.dao.UserInfoDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class Signup extends Service {

	@Override
	public void execute(RequestContext req, ResponseContext res)
			throws IOException, ResourceException, BadRequestException, NotFoundException {
		System.out.println("signupにきた");
		String userId = req.getParameter("id")[0];
		String nickName = req.getParameter("name")[0];
		String pass = req.getParameter("password")[0];
		String passAgain = req.getParameter("passwordAgain")[0];

		System.out.println(userId);
		System.out.println(nickName);
		System.out.println(req.getParameter("password")[0]);
		System.out.println(req.getParameter("passwordAgain")[0]);
		if(userId == null || userId.isEmpty()) {
			throw new BadRequestException("userIdが空");
		}
		
		//passwordのチェック
		if(pass == null || pass.isEmpty()) {
			throw new BadRequestException("passwordが空");
		}
		UserInfoDao dao = new UserInfoDao();
		UserInfoBean bean = new UserInfoBean();
		bean.setUserId(userId);
		bean.setNickname(nickName);
		bean.setPassword(pass);
		
		
		if(pass.equals(passAgain)) {
			dao.insertUser(bean);
			res.redirect("index");
		}else {
			throw new BadRequestException("パスワードが一致しないから諦めろ");
			
		}
		


	}

}
