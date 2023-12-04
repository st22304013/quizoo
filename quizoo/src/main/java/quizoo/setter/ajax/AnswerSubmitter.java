package quizoo.setter.ajax;

import java.io.IOException;

import com.google.gson.Gson;

import db.bean.AnswerhistoryBean;
import db.bean.UserInfoBean;
import db.dao.AnswerHistoryDao;
import db.dao.UserInfoDao;
import frame.Service;
import frame.context.RequestContext;
import frame.context.ResponseContext;
import frame.exception.BadRequestException;
import frame.exception.NotFoundException;
import frame.exception.ResourceException;

public class AnswerSubmitter extends Service {

	@Override
	public void execute(RequestContext req, ResponseContext res) throws IOException, ResourceException, BadRequestException, NotFoundException {
		// TODO 自動生成されたメソッド・スタブ
         
        Gson gson = new Gson();
     
        AnswerhistoryBean historybean = gson.fromJson(req.getMessageBody(), AnswerhistoryBean.class);
        UserInfoBean userinfobean = gson.fromJson(req.getMessageBody(), UserInfoBean.class);
        
        AnswerHistoryDao answerhistoryDao = new AnswerHistoryDao();
        UserInfoDao userinfoDao = new UserInfoDao();
        //ここまでは多分良いが、Beanのインスタンス化がわからない
        
        
        
        //ここからanswerhistoryへのinsertやuserInfoのupdateを考える
        //answerhistoryへのisnert
        answerhistoryDao.insertAnswerHistory(0, 0, historybean.getAnsweredTime(), historybean.getCorrectCount());
        
        
        //userinfoへのupdate
        userinfoDao.updateScore(userinfobean.getTotalAnswer(), userinfobean.getCorrectAnswer());
        
    }
}
