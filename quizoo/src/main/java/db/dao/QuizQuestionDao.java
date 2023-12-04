package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.QuestionBean;
import db.bean.QuizBean;
import db.bean.QuizQuestionBean;
import frame.exception.ResourceException;

public class QuizQuestionDao extends Dao{
	public QuizQuestionBean selectQuizWithQuestion(int quizid) throws ResourceException{
		
		PreparedStatement st = null;
		ResultSet rs = null;
		QuizQuestionBean quizQuestionBean = new QuizQuestionBean();
		ArrayList<QuestionBean> questionList = new ArrayList<>(); 
		
		try {
			connect();
			
			String quiz_sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) WHERE quiz_id = ?";
			
			st = cn.prepareStatement(quiz_sql);
			st.setInt(1, quizid);
			rs = st.executeQuery();
			
			QuizBean  quizBean = new QuizBean();
			
			quizBean.setQuizId(rs.getInt("quiz_id"));
			quizBean.setAuthorNo(rs.getInt("author_no"));
			quizBean.setTitle(rs.getString("title"));
			quizBean.setQuestionCount(rs.getInt("question_count"));
			quizBean.setGenreNo(rs.getInt("genre_no"));
			quizBean.setGenre(rs.getString("genre"));
			quizBean.setExplanation(rs.getString("explanation"));
			quizBean.setCreateTime(rs.getString("create_time"));
			quizBean.setCorrectRate(rs.getFloat("correct_rate"));
			quizBean.setTotalParticipants(rs.getInt("total_participants"));
			
			quizQuestionBean.setQuiz(quizBean);
			
			String question_sql = "SELECT * FROM question WHERE quiz_id = ?";
			
			st = cn.prepareStatement(question_sql);
			st.setInt(1, quizid);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QuestionBean questionBean = new QuestionBean();
				
				questionBean.setQuiz_id(rs.getInt("quiz_id"));
				questionBean.setQuestion_id(rs.getInt("question_id"));
				questionBean.setQuestion(rs.getString("question"));
				questionBean.setChoice_1(rs.getString("choice_1"));
				questionBean.setChoice_1(rs.getString("choice_2"));
				questionBean.setChoice_1(rs.getString("choice_3"));
				questionBean.setChoice_1(rs.getString("choice_4"));
				byte judgeByte = rs.getByte("judge");
	            // ビット列をboolean[]に変換するメソッドを呼び出してセット
	            boolean[] judgeArray = byteToBooleanArray(judgeByte);
	            questionBean.setJudge(judgeArray);
				
				questionList.add(questionBean);
				
			}
			
			quizQuestionBean.setQuestion(questionList);
			
			cn.commit();
			
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                throw new ResourceException(e2.getMessage(), e2);
            }
            throw new ResourceException(e.getMessage(), e);
        } finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(st != null) {
                    st.close();
                }
            } catch(SQLException e2) {
                throw new ResourceException(e2.getMessage(), e2);
            } finally {
                close();
            }
        }
		return quizQuestionBean;
	}
	
	public void insertQuestion(QuestionBean question) throws ResourceException {
	    PreparedStatement st = null;

	    try {
	        connect();

	        String sql = "INSERT INTO question (quiz_id, question, choice_1, choice_2, choice_3, choice_4, judge) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        st = cn.prepareStatement(sql);

	        st.setInt(1, question.getQuiz_id());
	        st.setString(2, question.getQuestion());
	        st.setString(3, question.getChoice_1());
	        st.setString(4, question.getChoice_2());
	        st.setString(5, question.getChoice_3());
	        st.setString(6, question.getChoice_4());
	        // boolean[]からビット文字列に変換してセット
            String bitString = booleanArrayToBitString(question.getJudge());
            st.setString(7, bitString);

	        st.executeUpdate();

	        cn.commit();

	    } catch (SQLException e) {
	        try {
	            cn.rollback();
	        } catch (SQLException e2) {
	            throw new ResourceException(e2.getMessage(), e2);
	        }
	        throw new ResourceException(e.getMessage(), e);
	    } finally {
	        close();
	    }
	}
	
	// バイトをboolean[]に変換するメソッド
    private boolean[] byteToBooleanArray(byte b) {
        boolean[] result = new boolean[8];
        for (int i = 0; i < 8; i++) {
            result[i] = (b & (1 << i)) != 0;
        }
        return result;
    }
	
	// boolean[]をビット文字列に変換するメソッド
    private String booleanArrayToBitString(boolean[] boolArray) {
        StringBuilder builder = new StringBuilder();
        for (boolean b : boolArray) {
            builder.append(b ? "1" : "0");
        }
        return builder.toString();
    }

}
