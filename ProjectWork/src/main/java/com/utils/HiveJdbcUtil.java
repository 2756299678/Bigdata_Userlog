package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HiveJdbcUtil {

	//��������
	private  static String DriverName="org.apache.hive.jdbc.HiveDriver";
	//���ӵ�ַ
	private static String url="jdbc:hive2://192.168.72.10:10000/default";
	//���ݿ��û���
	public static String USER="root";
	//���ݿ�����
	public static String PWD="123456";
	
	
	//��ȡ����
	public static Connection getConnection(){
		
		Connection con=null;
		try {
			//��������
			Class.forName(DriverName);
			//��������
			con=DriverManager.getConnection(url, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��������
		return con;
	}
	//�ر�����
	/*
	*���ݿ�ر�
	*/
	public static void Close(Connection con,PreparedStatement pstmt,ResultSet rs){
		try {
			//�ж��Ƿ񱻲���
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
