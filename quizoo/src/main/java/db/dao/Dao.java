package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import frame.exception.ResourceException;


public abstract class Dao {
	protected static Connection cn;

	public void connect() throws ResourceException {
		
		try {
			
			Context c;
			String dataSource = "java:comp/env/jdbc/LoginTemplate";
			c = new InitialContext();
			DataSource ds = (DataSource)c.lookup(dataSource);
			
			
			cn = ds.getConnection();
			cn.setAutoCommit(false);
			
			System.out.println("コネクションプールからの取得に成功しました"+cn);
			
		} catch (NamingException | SQLException e) {
			System.out.println("コネクションプールからの取得に失敗しました");
			System.out.println("コネクションを再度取得します（プールを使用しない）");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizoo");
				
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				throw new ResourceException(e.getMessage(), e);
			}
		}
		
		
	}

	public void close() throws SQLException {
		cn.close();
	}

}
