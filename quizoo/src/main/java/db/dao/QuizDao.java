package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizDao extends Dao{	
	public QuizBean selectQuiz(int quizId) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		QuizBean quizbean = new QuizBean();
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz WHERE quiz_id = " + quizId; 
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				quizbean.setquizId(rs.getInt(1));
				quizbean.setAuthorNo = rs.getInt(2);
				quizbean.setAuthorNickname = rs.getString(3);
				quizbean.setTitle = rs.getString(4);
				quizbean.setQuestionCount = rs.getInt(5);
				quizbean.setGenreNo = rs.getInt(6);
				quizbean.setGenre = rs.getString(7);
				quizbean.setExplanation = rs.getString(8);
				quizbean.setCreateTime = rs.getString(9);
				quizbean.setCorrectRate = rs.getFloat(10);
				quizbean.setTotalParticipants = rs.getInt(11);	
				
				cn.commit();
			}
		} catch(ClassNotFoundException e) {
			
		} catch(SQLException e) {
			try {
				cn.rollback();
			} catch(SQLException e2) {
				
			}
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
			} catch(SQLException e2) {
				
			} finally {
				close();
			}
		}
		return quizbean;
	}
	
	public void insertQuiz(QuizBean quiz) {
		PreparedStatement st = null;
		
		try {
			connect();
            
			String sql = "INSERT INTO quiz VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			st = cn.prepareStatement(sql);
			
			st.setInt(1, quiz.getquizId());
			st.setInt(2, quiz.getAuthor_no());
			st.setString(3, quiz.geAuthorNicknamet());
			st.setString(4, quiz.getTitle());
			st.setInt(5, quiz.getQuestionCount());
			st.setInt(6, quiz.getGenreNo());
			st.setString(7, quiz.getGenre());
			st.setString(8, quiz.getExplanation());
			st.setString(9, quiz.getCreateTime());
			st.setFloat(10, getCorrectRate());
			st.setInt(11, getTotalParticipants());
			
			st.executeUpdate();
			
			cn.commit();
	
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
            close();
        }
		
	}
	
	public void deleteQuiz(int quizId) {
		PreparedStatement st = null;
		
		try {
			connect();
			
			String sql = "DELETE FROM quiz WHERE quizId = " + quizId;
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
        	close();
        }
		
	}
	
	public void updateTitle(int quizId, int title) {
		PreparedStatement st = null;
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET title = " +  title + " WHERE quizId = " + quizId;
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
        	close();
        }
		
	}
	
	public void updateGenre(int quizId, int genreNo) {
		PreparedStatement st = null;
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET genreNo = " +  genreNo + " WHERE quizId = " + quizId;
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
        	close();
        }
	}
	
	public void updateExplanation(int quizId, String explanation) {
		PreparedStatement st = null;
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET explanation = " +  explanation + " WHERE quizId = " + quizId;
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
        	close();
        }
		
	}
	
	public void updateRateAndTotalPaticipants(int quizId, int score) {
		PreparedStatement st = null;
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET  score = " + score + " WHERE quizId = " + quizId;
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(ClassNotFoundException e) {
			
        } catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
                
            }
        } finally {
        	close();
        }
	}


}
