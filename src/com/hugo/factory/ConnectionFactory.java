package com.hugo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ticket";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	public Connection createConnection(){
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (Exception e) {
			System.out.println("Error in mySQL: " + URL);
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void fecharConnection(Connection connection, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(connection != null){
				connection.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Error in connection: " + URL);
		}
		
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

