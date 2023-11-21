package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizQuestionDao extends Dao{
	public QuizQuestionBean selectQuizWithQuestion(int quizid) throws ResourceException{
		
		PreparedStatement st = null;
		ResultSet rs = null;
		QuizQuestionBean quizQuestionBean = new QuizQuestionBean();
		ArrayList<QuestionBean> questionList = new ArrayList<>(); 
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz INNER JOIN question ON quiz.quiz_id = question.quiz_id WHERE quiz_id = ?";
			
			st = cn.prepareStatement(sql);
			st.setInt(1, quizid);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QuizBean  quizBean = new QuizBean();
				QuestionBean questionBean = new QuestionBean();
				
				questionBean.setQuizId(rs.getInt(1));
				questionBean.setQuestionId(rs.getInt(2));
				questionBean.setQuestion(rs.getString(3));
				questionBean.setChoice1(rs.getString(4));
				questionBean.setChoice2(rs.getString(5));
				questionBean.setChoice3(rs.getString(6));
				questionBean.setChoice4(rs.getString(7));
				questionBean.setJudge(rs.getByte(8));
				
				questionList.add(questionBean);
				
				quizBean.setQuizId(rs.getInt(1));
				quizBean.setAuthorNo(rs.getInt(2));
				quizBean.setTitle(rs.getString(3));
				quizBean.setQuestionCount(rs.getInt(4));
				quizBean.setGenreNo(rs.getInt(5));
				quizBean.setExplanation(rs.getString(6));
				quizBean.setCreateTime(rs.getString(7));
				quizBean.setCorrectRate(rs.getFloat(8));
				quizBean.setTotalParticipants(rs.getInt(9));
				
				quizQuestionBean.setQuiz(quizBean);
				quizQuestionBean.setQuestions(questionList);
		
			}
			cn.commit();
			
		} catch(ClassNotFoundException e) {
            throw new ResourceException(e.getMessage(), e);
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
}
