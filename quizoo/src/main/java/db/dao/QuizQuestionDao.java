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
			//quiz表とgenre表をgenre_noで内部結合しデータを取得
			String quiz_sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) WHERE quiz_id = ?";
			
			st = cn.prepareStatement(quiz_sql);
			st.setInt(1, quizid);
			rs = st.executeQuery();
			
			QuizBean  quizBean = new QuizBean();
			
			//QuizBeanにデータセット
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
			
			//question表からデータを取得
			String question_sql = "SELECT * FROM question WHERE quiz_id = ?";
			
			st = cn.prepareStatement(question_sql);
			st.setInt(1, quizid);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QuestionBean questionBean = new QuestionBean();
				//QuestionBeanにデータセット

				questionBean.setQuizId(rs.getInt("quiz_id"));
				questionBean.setQuestionId(rs.getInt("question_id"));
				questionBean.setQuestion(rs.getString("question"));
				questionBean.setChoice1(rs.getString("choice_1"));
				questionBean.setChoice2(rs.getString("choice_2"));
				questionBean.setChoice3(rs.getString("choice_3"));
				questionBean.setChoice4(rs.getString("choice_4"));
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
	
	public void insertQuestion(QuizQuestionBean quizQuestionBean) throws ResourceException {
	    PreparedStatement st = null;

	    try {
	        connect();

	        String sql = "INSERT INTO question (quiz_id, question_id, question, choice_1, choice_2, choice_3, choice_4, judge) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			st = cn.prepareStatement(sql);
			
			for (QuestionBean question : quizQuestionBean.getQuestion()) {
				st.setInt(1, question.getQuizId());
				st.setInt(2, question.getQuestionId());
				st.setString(3, question.getQuestion());
				st.setString(4, question.getChoice1());
				st.setString(5, question.getChoice2());
				st.setString(6, question.getChoice3());
				st.setString(7, question.getChoice4());
				
//				//boolean[]からビット文字列に変換してセット
//				String bitString = booleanArrayToBitString(question.getJudge());
//				st.setString(8, bitString);
				
				// boolean[]からbyteに変換するメソッドを呼び出してセット
	            byte judgeByte = booleanArrayToByte(question.getJudge());
	            st.setByte(8, judgeByte);
				
				System.out.println("Quiz ID: " + question.getQuizId());
				System.out.println("Question ID: " + question.getQuestionId());
				System.out.println("Question: " + question.getQuestion());
				System.out.println("Choice 1: " + question.getChoice1());
				System.out.println("Choice 2: " + question.getChoice2());
				System.out.println("Choice 3: " + question.getChoice3());
				System.out.println("Choice 4: " + question.getChoice4());
				System.out.println("Judge: " + judgeByte);
	            
	            System.out.println("executeUpdate直前");
	
		        st.executeUpdate();
	            System.out.println("executeUpdate完了");
			}

	        cn.commit();
            System.out.println("questionのcommit完了");

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
	
//	// boolean[]をビット文字列に変換するメソッド
//    private String booleanArrayToBitString(boolean[] boolArray) {
//        StringBuilder builder = new StringBuilder();
//        for (boolean b : boolArray) {
//            builder.append(b ? "1" : "0");
//        }
//        return builder.toString();
//    }

    // boolean[]をバイトに変換するメソッド
    private byte booleanArrayToByte(boolean[] boolArray) {
        if (boolArray.length > 8) {
            throw new IllegalArgumentException("Boolean array size should not exceed 8 elements.");
        }

        byte result = 0;
        for (int i = 0; i < boolArray.length; i++) {
            if (boolArray[i]) {
                result |= (1 << i);
            }
        }
        return result;
    }

}
