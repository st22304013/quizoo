package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import db.bean.GenreBean;
import frame.exception.ResourceException;

public class GenreDao extends Dao {
	public ArrayList<GenreBean> selectGenre() throws ResourceException {
		ArrayList<GenreBean> genreList = new ArrayList<>();
		
		connect();
		
		String sql = "SELECT * FROM genre ORDER BY genre_no ASC";
		
		
		try {
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				GenreBean quiz = new GenreBean();
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
