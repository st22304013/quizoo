package quizoo.setter.ajax;

import java.io.IOException;

import com.google.gson.Gson;

import db.bean.AnswerhistoryBean;
import db.dao.AnswerHistoryDao;
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
     
        AnswerhistoryBean bean = gson.fromJson(req.getMessageBody(), AnswerhistoryBean.class);
        
        AnswerHistoryDao answerhistoryDao = new AnswerHistoryDao();
        //ここまでは多分確定
        
        
        
        //ここからanswerhistoryへのinsertやuserInfoのupdateを考える
        //isnert
        
        
        
        
        //update

    }
}
