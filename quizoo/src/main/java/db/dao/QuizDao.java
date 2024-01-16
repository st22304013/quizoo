package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.QuizBean;
import frame.exception.ResourceException;

/**
 * quiz表にアクセスします
 */
public class QuizDao extends Dao{
	
	/**
	 * ソートされたQuiz一覧を取得します
	 * @param columnName 並べ替えに使用する列名。quiz表に存在しない列名が渡された場合は例外が発生します
	 * @return ArrayListに格納されたQuizBeanを返します
	 * @throws ResourceException データ取得時に例外が発生した場合
	 */
	public ArrayList<QuizBean> selectOrderedQuizByColumnName(String columnName)throws ResourceException{

		ArrayList<QuizBean> quizlist = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) LEFT OUTER JOIN nickname on quiz.author_no = nickname.user_no ORDER BY "; 
			sql = sql + columnName;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QuizBean quizbean = new QuizBean();
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setQuestionCount(rs.getInt("question_count"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				quizbean.setGenre(rs.getString("genre_title"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));	
				quizbean.setAuthorNickname(rs.getString("nickname"));
				quizlist.add(quizbean);
				
			}
		} catch(SQLException e) {
			try {
				cn.rollback();
			} catch(SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
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
				throw new ResourceException(e2.getMessage(), e2);
			} finally {
				close();
			}
		}
		return quizlist;
		
	}	
	
	/**
	 * @return create_time列でソートされたQuiz一覧を取得します
	 * @throws ResourceException データ取得時に例外が発生した場合
	 */
	public ArrayList<QuizBean> selectQuiz() throws ResourceException {
		return selectOrderedQuizByColumnName("create_time");
	}
	
	/**
	 * 指定されたクイズを取得します。
	 * @param quizId quiz表quiz_id列に対応した値。存在しない場合は例外が空のQuizBeanが帰る
	 * @return 取得されたクイズのQuizBean
	 * @throws ResourceException データ取得時に例外が発生した場合
	 */
	public QuizBean selectSearchedQuizByQuizId(int quizId) throws ResourceException {
		
		QuizBean quizbean = new QuizBean();
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) WHERE quiz_id = ?"; 
			st = cn.prepareStatement(sql);
			st.setInt(1, quizId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setQuestionCount(rs.getInt("question_count"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				quizbean.setGenre(rs.getString("genre"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));	
			
			}
		} catch(SQLException e) {
			try {
				cn.rollback();
			} catch(SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
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
				throw new ResourceException(e2.getMessage(), e2);
			} finally {
				close();
			}
		}
		return quizbean;
	}
	
	
	/**
	 * 指定されたジャンルの指定された列で並び変えられたQuiz一覧を取得します
	 * @param columnName 並べ替えに使用する列名。quiz表に存在しない列名が渡された場合は例外が発生します
	 * @param genreNo genre表genre_no列に対応した値。存在しない場合は結果が0件
	 * @return ArrayListに格納されたQuizBeanを返します
	 * @throws ResourceException ResourceException データ取得時に例外が発生した場合
	 */
	public ArrayList<QuizBean> selectQuizByColumnNameAndGenreNo(String columnName, int genreNo)throws ResourceException{
		
		ArrayList<QuizBean> quizlist = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) WHERE genre_no = ? ORDER BY "; 
			sql = sql + columnName;
			st = cn.prepareStatement(sql);
			st.setInt(1,genreNo);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QuizBean quizbean = new QuizBean();
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setQuestionCount(rs.getInt("question_count"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				quizbean.setGenre(rs.getString("genre_title"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));	
				
				quizlist.add(quizbean);
				
			}
		} catch(SQLException e) {
			try {
				cn.rollback();
			} catch(SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
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
				throw new ResourceException(e2.getMessage(), e2);
			} finally {
				close();
			}
		}
		return quizlist;
		
	}

	/**
	 * 指定されたジャンルに登録されているQuiz一覧を指定されている列名で並び変えて取得します
	 * @param genreNo 絞り込むジャンルを指定します
	 * @return ArrayListに格のされたQuizBeanを返します
	 * @throws ResourceException ResourceException データ取得時に例外が発生した場合
	 */
	public ArrayList<QuizBean> selectSearchedQuizByGenreNo(int genreNo) throws ResourceException {
		
		QuizBean quizbean = new QuizBean();
		ArrayList<QuizBean> quizList = new ArrayList<>();
		
		try {
			connect();
			
			String sql = "SELECT * FROM quiz INNER JOIN genre USING(genre_no) WHERE genre_no = ?"; 
			st = cn.prepareStatement(sql);
			st.setInt(1, genreNo);
			rs = st.executeQuery();
			
			while(rs.next()) {
				quizbean.setQuizId(rs.getInt("quiz_id"));
				quizbean.setAuthorNo(rs.getInt("author_no"));
				quizbean.setTitle(rs.getString("title"));
				quizbean.setQuestionCount(rs.getInt("question_count"));
				quizbean.setGenreNo(rs.getInt("genre_no"));
				quizbean.setGenre(rs.getString("genre"));
				quizbean.setExplanation(rs.getString("explanation"));
				quizbean.setCreateTime(rs.getString("create_time"));
				quizbean.setCorrectRate(rs.getFloat("correct_rate"));
				quizbean.setTotalParticipants(rs.getInt("total_participants"));	
				
				quizList.add(quizbean);

			}
		} catch(SQLException e) {
			try {
				cn.rollback();
			} catch(SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
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
				throw new ResourceException(e2.getMessage(), e2);
			} finally {
				close();
			}
		}
		return quizList;
	}
	
	/**
	 * quiz表にQuizBeanのデーターを挿入します
	 * @param quiz 挿入するQuizのBean
	 * @throws ResourceException データ挿入時に例外が発生した場合
	 */
	public void insertQuiz(QuizBean quiz) throws ResourceException {
		
		try {
			connect();
            
			String sql = "INSERT INTO quiz VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			st = cn.prepareStatement(sql);
			
			st.setInt(1, quiz.getQuizId());
			st.setInt(2, quiz.getAuthorNo());
			st.setString(3, quiz.getTitle());
			st.setInt(4, quiz.getQuestionCount());
			st.setInt(5, quiz.getGenreNo());
			st.setString(6, quiz.getExplanation());
			st.setString(7, quiz.getCreateTime());
			st.setFloat(8, quiz.getCorrectRate());
			st.setInt(9, quiz.getTotalParticipants());
			
			st.executeUpdate();
			
			cn.commit();
            System.out.println("quizのcommit完了");
			
	
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
            	throw new ResourceException(e2.getMessage(), e2);
            }
        } finally {
            close();
        }
		
	}
	
	/**
	 * quiz表からデータを削除します
	 * @param quizId 削除するQuizのquiz_no
	 * @throws ResourceException データーの削除時に例外が発生した場合
	 */
	public void deleteQuiz(int quizId) throws ResourceException {
		
		try {
			connect();
			
			String sql = "DELETE FROM quiz WHERE quiz_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1, quizId);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
            	throw new ResourceException(e2.getMessage(), e2);
            }
        } finally {
        	close();
        }
		
	}
	
	/**
	 * クイズのタイトルを変更します
	 * @param quizId 変更するデータのquiz_id
	 * @param title クイズの新しいタイトル
	 * @throws ResourceException タイトル変更時に例外が発生した場合
	 */
	public void updateTitle(int quizId, String title) throws ResourceException {
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET title = ? WHERE quiz_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, title);
			st.setInt(2, quizId);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
            	throw new ResourceException(e2.getMessage(), e2);
            }
        } finally {
        	close();
        }
		
	}
	
	/**
	 * クイズのジャンルを変更します
	 * @param quizId 変更するデータのquiz_id
	 * @param genreNo クイズの新しいジャンル
	 * @throws ResourceException ジャンルの変更時に例外が発生した場合
	 */
	public void updateGenre(int quizId, int genreNo) throws ResourceException{
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET genre_no = ? WHERE quiz_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1, genreNo);
			st.setInt(2, quizId);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
            	throw new ResourceException(e2.getMessage(), e2);
            }
        } finally {
        	close();
        }
	}
	
	/**
	 * クイズの説明を変更します
	 * @param quizId 変更するデータのtitle
	 * @param explanation クイズの新しい説明
	 * @throws ResourceException 説明の変更時に例外が発生した場合
	 */
	public void updateExplanation(int quizId, String explanation) throws ResourceException {
		
		try {
			connect();
			
			String sql = "UPDATE quiz SET explanation = ? WHERE quiz_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, explanation);
			st.setInt(2, quizId);
			
			st.executeUpdate();
			
			cn.commit();
			
		} catch(SQLException e) {
            try{
                cn.rollback();
            } catch(SQLException e2) {
            	throw new ResourceException(e2.getMessage(), e2);
            }
        } finally {
        	close();
        }
		
	}
}
