package quizoo.setter.ajax;

import java.io.IOException;

import com.google.gson.Gson;

import db.bean.AnswerhistoryWithUserinfoBean;
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

        UserInfoBean bean = req.getUser();
        
        AnswerhistoryWithUserinfoBean historyWithUserinfoBean = gson.fromJson(req.getMessageBody(), AnswerhistoryWithUserinfoBean.class);
        
        
        AnswerHistoryDao answerhistoryDao = new AnswerHistoryDao();
        UserInfoDao userinfoDao = new UserInfoDao();
        
        
        //ここからanswerhistoryへのinsertやuserInfoのupdateを考える
        //answerhistoryへのisnert  userNoはsessionから持ってくる
        answerhistoryDao.insertAnswerHistory(bean.getUserNo(), historyWithUserinfoBean.getQuizId(), historyWithUserinfoBean.getAnsweredTime(), historyWithUserinfoBean.getCorrectCount());
        
        
        //userinfoへのupdate
        userinfoDao.updateScore(bean.getUserNo(), historyWithUserinfoBean.getTotalAnswer(), historyWithUserinfoBean.getCorrectAnswer());
        
    }
}
