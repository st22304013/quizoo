package db.dao;

import java.util.ArrayList;

import db.bean.AnswerhistoryBean;
import frame.exception.ResourceException;

public class AnswerHistoryDao extends Dao {
	public ArrayList<AnswerhistoryBean> selectAnswerHistory(int userId) throws ResourceException {

		ArrayList<AnswerhistoryBean> bean = null;

		connect();
		
		return bean;
	}
}
