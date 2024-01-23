package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.QuizBean;
import frame.exception.ResourceException;

public class CreateHistoryDao extends Dao {
	
	public ArrayList<QuizBean> selectCreateHistory(int userNo) throws ResourceException {
		//回答履歴を格納するArrayList
		ArrayList<QuizBean> createhistory = new ArrayList<>();
		

		connect();
		
		String sql = "SELECT q.quiz_id AS quiz_id,"
				+ "q.author_no AS author_no,"
				+ "q.title AS title,"
				+ "q.question_count AS question_count,"
				+ "q.genre_no AS genre_no,"
				+ "q.explanation AS explanation,"
				+ "q.create_time AS create_time,"
				+ "q.correct_rate AS correct_rate ,"
				+ "q.total_participants AS total_participants,"
				+ "g.genre_title AS genre_title"	 
				+ " FROM genre g "
				+ " INNER JOIN quiz q"
				+ " USING (genre_no)"
				+ " WHERE author_no = ?"
				+ " ORDER BY create_time desc";
		
		
		try {
			st = cn.prepareStatement(sql);
			st.setInt(1, userNo);
			
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				
				//QuizBeanの作成とセット
				QuizBean quizbean = new QuizBean();
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setQuestionCount(rs.getInt("question_count"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				
				
				
				//Listに追加
				createhistory.add(quizbean);
			}
			
			
			
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}
		
		close();
		
		return createhistory.isEmpty() ? null : createhistory;
	}
}
