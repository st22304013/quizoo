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
			
			String quiz_sql = "SELECT * FROM quiz INNER JOIN genre ON quiz.genre_no = genre.genre_no WHERE quiz_id = ?";
			
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
				
				questionBean.setQuizId(rs.getInt("quiz_id"));
				questionBean.setQuestionId(rs.getInt("question_id"));
				questionBean.setQuestion(rs.getString("question"));
				questionBean.setChoice1(rs.getString("choice_1"));
				questionBean.setChoice2(rs.getString("choice_2"));
				questionBean.setChoice3(rs.getString("choice_3"));
				questionBean.setChoice4(rs.getString("choice_4"));
				questionBean.setJudge(rs.getByte("judge"));
				
				questionList.add(questionBean);
				
			}
			
			quizQuestionBean.setQuestions(questionList);
			
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
