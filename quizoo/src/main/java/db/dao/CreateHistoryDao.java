package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.AnswerhistoryBean;
import db.bean.QuizBean;
import frame.exception.ResourceException;

public class CreateHistoryDao extends Dao {
	
	public ArrayList<AnswerhistoryBean> selectAnswerHistory(int userNo) throws ResourceException {
		//回答履歴を格納するArrayList
		ArrayList<AnswerhistoryBean> Answerhistory = new ArrayList<>();
		

		connect();
		
		String sql = "SELECT quiz_id, title, author_no, answered_time, a.question_count AS q_count, q.question_count AS now_count,genre_no,correct_count, explanation, create_time, correct_rate, total_participants "
				+ " FROM answerhistory a"
				+ " INNER JOIN quiz q"
				+ " ON q.quiz_id = a.author_no"
				+ " WHERE user_no = author_no"
				+ " ORDER BY create_time asc";
		
		
		try {
			st = cn.prepareStatement(sql);
			st.setInt(1, userNo);
			
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				//結果セットからデータを取得してAnswerhistoryBeanにセット
				AnswerhistoryBean answerhistorybean = new AnswerhistoryBean();
				answerhistorybean.setAnsweredTime(rs.getString("answered_time"));
				answerhistorybean.setQuestionCount(rs.getInt("q_count"));
				answerhistorybean.setCorrectCount(rs.getInt("correct_count"));
				
				//QuizBeanの作成とセット
				QuizBean quizbean = new QuizBean();
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setQuestionCount(rs.getInt("now_count"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				
				answerhistorybean.setQuizBean(quizbean);
				
				//Listに追加
				Answerhistory.add(answerhistorybean);
			}
			
			
			
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}
		
		close();
		
		return Answerhistory.isEmpty() ? null : Answerhistory;
	}
}
