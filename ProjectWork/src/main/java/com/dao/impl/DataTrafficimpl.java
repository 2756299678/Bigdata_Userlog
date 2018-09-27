package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DataTrafficDao;
import com.entity.DataNumber;
import com.entity.DataTraffic;
import com.utils.HiveJdbcUtil;
import com.utils.JDBCUtil;

public class DataTrafficimpl implements DataTrafficDao {

	/**
	 * 获取数据
	 */
	@Override
	public List<DataTraffic> getfromData() {
		// TODO Auto-generated method stub
		List<DataTraffic> datas=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			connection=JDBCUtil.getConnection();
			statement=connection.createStatement();
			String sql="select type,type_id,sum(traffic) as traffic from data GROUP BY type,type_id ORDER BY traffic DESC LIMIT 10;";
			resultset=statement.executeQuery(sql);
			while(resultset.next())
			{
				String type=resultset.getString("type");;
				String type_id=resultset.getString("type_id");
				long traffic=resultset.getLong("traffic");
				
				DataTraffic data=new DataTraffic(type,type_id,traffic); 
				
				datas.add(data);
			}
			 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.Close(connection, statement, null);
		}
		
		return datas;
	}

	@Override
	public void add(DataTraffic data) {
		// TODO Auto-generated method stub
		Connection connnection=null;
		PreparedStatement statement=null;
		String sql = "insert into datatraffic(type,type_id,traffic) values(?,?,?)";
		System.out.println(sql);
		try
		{
			connnection=JDBCUtil.getConnection();
			statement=connnection.prepareStatement(sql);
			statement.setString(1,data.getType());
			statement.setString(2,data.getType_id());
			statement.setLong(3,data.getTraffic());
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
	public List<DataTraffic> getall() {
		// TODO Auto-generated method stub
		List<DataTraffic> datas=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			connection=JDBCUtil.getConnection();
			statement=connection.createStatement();
			String sql="select type,type_id,traffic from datatraffic;";
			resultset=statement.executeQuery(sql);
			while(resultset.next())
			{
				String type=resultset.getString("type");;
				String type_id=resultset.getString("type_id");
				long traffic=resultset.getLong("traffic");
				
				DataTraffic data=new DataTraffic(type,type_id,traffic); 
				
				datas.add(data);
			}
			 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.Close(connection, statement, null);
		}
		
		return datas;
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		Connection connnection=null;
		PreparedStatement statement=null;
		String sql = "delete from datatraffic";
		System.out.println(sql);
		try
		{
			connnection=JDBCUtil.getConnection();
			statement=connnection.prepareStatement(sql);
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
	public List<DataTraffic> getfromHive() {
		// TODO Auto-generated method stub
		List<DataTraffic> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=HiveJdbcUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select type,type_id,sum(traffic) as traffic from test GROUP BY type,type_id ORDER BY traffic DESC LIMIT 10 ";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 
				 //String type=resultset.getString("type");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 Long number=resultset.getLong("traffic");
				 
				 DataTraffic data=new DataTraffic(type,id,number);
				 lists.add(data);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
}
