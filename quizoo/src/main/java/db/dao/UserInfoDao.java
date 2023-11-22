package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.bean.UserInfoBean;
import frame.exception.ResourceException;

public class UserInfoDao extends Dao {

	public UserInfoBean selectUser(String user_id) throws ResourceException {

		PreparedStatement st = null;
		ResultSet rs = null;
		UserInfoBean userbean = new UserInfoBean();

		try {
			connect();

			String sql = "SELECT * FROM userinfo JOIN nickname USING(user_no) WHERE user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, user_id);
			rs = st.executeQuery();
			if (rs.next()) {
				userbean.setUserId(rs.getString("user_id"));
				userbean.setUserNo(rs.getInt("user_no"));
				userbean.setNickname(rs.getString("nickname"));
				userbean.setPassword(rs.getString("password"));
				userbean.setTotalAnswer(rs.getInt("total_answer"));
				userbean.setCorrectAnswer(rs.getInt("correct_answer"));
				userbean.setRating(rs.getFloat("rating"));
			}

		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
			} finally {
				close();
			}
		}
		return userbean;
	}

	public void InsertUser(UserInfoBean user) throws ResourceException {
		PreparedStatement st = null;

		try {
			connect();

			String sql = " INSERT INTO userinfo VALUES(?,?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);

			st.setString(1, user.getUserId());
			st.setInt(2, user.getUserNo());
			st.setString(3, user.getNickname());
			st.setString(4, user.getPassword());
			st.setInt(5, user.getTotalAnswer());
			st.setInt(6, user.getCorrectAnswer());
			st.setFloat(7, user.getRating());
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}

	}

	public void deleteUser(String user_id) throws ResourceException {
		PreparedStatement st = null;
		try {
			connect();

			String sql = "DELETE FROM userinfo WHERE user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, user_id);

			st.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (SQLException e2) {
				throw new ResourceException(e2.getMessage(), e2);
			}
		} finally {
			close();
		}
	}

	public void updatePassword(String user_id, String password) throws ResourceException {
		PreparedStatement st = null;
		try {
			connect();

			String sql = "UPDATE userinfo SET password =? WHERE user_id =?";
			st = cn.prepareStatement(sql);
			st.setString(1, password);
			st.setString(2, user_id);

			st.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		} finally {
			close();
		}
	}

	public void updateScore(int answered, int correct) throws ResourceException {
		PreparedStatement st = null;
		try {
			connect();
			String sql = "UPDATE userinfo SET total_answered = total_answered + ?,correct_ansewerd = correct_answered + ?";
			st = cn.prepareStatement(sql);
			st.setInt(1, answered);
			st.setInt(2, correct);
			st.executeUpdate();

			cn.commit();
		} catch (SQLException e) {
			throw new ResourceException(e.getMessage(), e);
		}
	}
}
