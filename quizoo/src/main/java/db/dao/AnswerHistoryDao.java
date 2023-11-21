package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.AnswerhistoryBean;
import frame.exception.ResourceException;

public class AnswerHistoryDao extends Dao {
	public ArrayList<AnswerhistoryBean> selectAnswerHistory(int userNo) throws ResourceException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AnswerhistoryBean> Answerhistory = null;
		

		connect();
		
		String sql = "SELECT q.quiz_id, title, answered_time, a.question_count,correct_count FROM answerhistory a"
				+ " INNER JOIN quiz q"
				+ " USING (quiz_id)"
				+ " WHERE user_no = ?";
		
		try {
			st.setInt(1, userNo);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int quizId = rs.getInt(1);
				String title = rs.getString(2);
				String answeredTime = rs.getString(3);
				int questionCount = rs.getInt(4);
				int correctCount = rs.getInt(5);
				
				
			
				AnswerhistoryBean bean = new AnswerhistoryBean();
				bean.setQuizId(quizId);
				bean.setTitle(title);
				bean.setAnsweredTime(answeredTime);
				bean.setQuestionCount(questionCount);
				bean.setCorrectCount(correctCount);
				
				Answerhistory.add(bean);
			}
			
			
			
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}
		
		close();
		
		return Answerhistory;
	}
}
