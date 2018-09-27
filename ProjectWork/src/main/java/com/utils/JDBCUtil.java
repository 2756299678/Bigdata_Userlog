package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtil {
	
	public static String URL="jdbc:mysql://192.168.72.10:3306/test2?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
	
	public static String USER="root";
	
	public static String PWD="123456";
	
	
	public static Connection getConnection(){
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	/*
	*关闭连接
	*/
	public static void Close(Connection con,Statement statement,ResultSet rs){
		try {
			
			if(rs!=null)
				rs.close();
			if(statement!=null)
				statement.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
