package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DataNumberDao;
import com.entity.DataNumber;
import com.utils.HiveJdbcUtil;
import com.utils.JDBCUtil;

public class DataNumberimpl implements DataNumberDao{

	@Override
	public List<DataNumber> getListBynumber() {
		// TODO Auto-generated method stub
		List<DataNumber> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=HiveJdbcUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select type,type_id,count(*) as number from data group by type,type_id order by number desc limit 10 ";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 
				 //String type=resultset.getString("type");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 int number=resultset.getInt("number");
				 
				 DataNumber data=new DataNumber(type,id,number);
				 lists.add(data);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public void add(DataNumber data) {
		// TODO Auto-generated method stub
		Connection connnection=null;
		PreparedStatement statement=null;
		String sql = "insert into datanumber(type,type_id,number) values(?,?,?)";
		System.out.println(sql);
		
		try
		{
			connnection=JDBCUtil.getConnection();
			statement=connnection.prepareStatement(sql);
			statement.setString(1, data.getType());
			statement.setString(2, data.getType_id());
			statement.setInt(3, data.getNumber());
			//执行更新操作
			statement.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.Close(connnection, statement, null);
		}
	}

	@Override
	public List<DataNumber> getListAll() {
		// TODO Auto-generated method stub
		List<DataNumber> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=JDBCUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select type,type_id,number from datanumber";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 
				 //String type=resultset.getString("type");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 int number=resultset.getInt("number");
				 
				 DataNumber data=new DataNumber(type,id,number);
				 lists.add(data);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.Close(connection, statement, null);
		}
		return lists;
	}

	@Override
	public List<DataNumber> getListBigBynumber() {
		// TODO Auto-generated method stub
		List<DataNumber> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=HiveJdbcUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select type,type_id,count(*) as number from test group by type,type_id order by number desc limit 10 ";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 
				 //String type=resultset.getString("type");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 int number=resultset.getInt("number");
				 
				 DataNumber data=new DataNumber(type,id,number);
				 lists.add(data);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	

}
