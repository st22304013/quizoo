package db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import db.bean.UserInfoBean;
import frame.exception.ResourceException;

public class UserInfoDao extends Dao {

	public UserInfoBean selectUser(String userId) throws ResourceException {

		PreparedStatement st = null;
		ResultSet rs = null;
		UserInfoBean userbean = new UserInfoBean();

		try {
			connect();

			String sql = "SELECT * FROM userinfo WHERE quiz_id = ?"; 
			st = cn.prepareStatement(sql);
			st.setString(1, userId);
			rs = st.executeQuery();


				cn.commit();
		} catch(ClassNotFoundException e) {
			throw new ResourceException(e.getMessage(), e);
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
		return userbean;
	}


public void InsertUser(UserInfoBean user) throws ResourceException{
	PreparedStatement st = null;
	
	try {
			connect();
			
			String sql =" INSERT INTO userinfo VALUES(?,?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			
			st.setString(1,user.getUserId());
			st.setInt(2,user.getUserNo());
			st.setString(3,user.getNickname());
			st.setString(4,user.getPassword());
			st.setInt(5,user.getTotalAnswer());
			st.setInt(6,user.getCorrectAnswer());
			st.setFloat(7,user.getRating());
}