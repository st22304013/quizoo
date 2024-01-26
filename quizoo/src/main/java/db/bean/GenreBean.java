package db.bean;

import java.io.Serializable;

public class GenreBean implements Serializable {
	private int genreNo;
	private String genre;
	
	public GenreBean() {}
	
	public GenreBean(int genreNo, String genre) {
		this.setGenreNo(genreNo);
		this.setGenre(genre);
	}

	public int getGenreNo() {
		return genreNo;
	}

	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
