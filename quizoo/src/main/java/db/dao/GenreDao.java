package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.QuizBean;
import frame.exception.ResourceException;

public class GenreDao extends Dao {
	public ArrayList<QuizBean> selectGenre() throws ResourceException {
		ArrayList<QuizBean> genreList = new ArrayList<>();
		
		connect();
		
		String sql = "SELECT * FROM quiz ORDER BY genre_no ASC";
		
		
		try {
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			
			while (rs.next()) {
                QuizBean quiz = new QuizBean();
                quiz.setGenreNo(rs.getInt("genre_no"));
                quiz.setGenre(rs.getString("genre"));

                genreList.add(quiz);
            }
			
			
			
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}
		
		close();
		
		return genreList;
		
	}
}
