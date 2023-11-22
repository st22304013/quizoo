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
				int quizId = rs.getInt("q.quiz_id");
				String title = rs.getString("title");
				String answeredTime = rs.getString("answered_time");
				int questionCount = rs.getInt("a.question_count");
				int correctCount = rs.getInt("correct_count");
				
				
			
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
	
	public void insertAnswerHistory(int userNo, int quizId, String answeredTime, int questionCount, int correctCount) throws ResourceException {
		
		PreparedStatement st = null;
		
		connect();
		
		String sql = "INSERT INTO answeredhistory (user_no, quiz_id, answered_time, question_count, correct_count)"
				+ "VALUES(?, ?, now(0), ?, ?)";
		
		st = cn.prepareStatement(sql);
		
		st.setInt(1, userNo);
		st.setInt(2, quizId);
		st.setString(3, answeredTime);
		st.setInt(4, questionCount);
		st.setInt(5,correctCount);
		
		close();		
		
	}
}





