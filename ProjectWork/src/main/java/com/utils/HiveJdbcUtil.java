package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HiveJdbcUtil {

	//加载驱动
	private  static String DriverName="org.apache.hive.jdbc.HiveDriver";
	//链接地址
	private static String url="jdbc:hive2://192.168.72.10:10000/default";
	//数据库用户名
	public static String USER="root";
	//数据库密码
	public static String PWD="123456";
	
	
	//获取链接
	public static Connection getConnection(){
		
		Connection con=null;
		try {
			//加载驱动
			Class.forName(DriverName);
			//创建链接
			con=DriverManager.getConnection(url, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回连接
		return con;
	}
	//关闭链接
	/*
	*数据库关闭
	*/
	public static void Close(Connection con,PreparedStatement pstmt,ResultSet rs){
		try {
			//判断是否被操作
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
