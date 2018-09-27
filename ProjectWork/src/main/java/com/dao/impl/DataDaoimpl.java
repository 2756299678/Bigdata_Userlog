package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DataDao;
import com.entity.Data;
import com.entity.DataNumber;
import com.utils.HiveJdbcUtil;
import com.utils.JDBCUtil;

public class DataDaoimpl implements DataDao{

	@Override
	public List<Data> getAllList() {
		// TODO Auto-generated method stub
		List<Data> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=HiveJdbcUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select ip,time,day,traffic,type,type_id from data";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 String ip=resultset.getString("ip");
				 String time=resultset.getString("time");
				 String day=resultset.getString("day");
				 String traffic=resultset.getString("traffic");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 Data data=new Data(ip,time,day,traffic,type,id);
				 lists.add(data);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
	
	
	public void  add(Data data)
	{
		Connection connnection=null;
		PreparedStatement statement=null;
		String sql = "insert into data(ip,time,day,traffic,type,type_id) values(?,?,?,?,?,?)";
		System.out.println(sql);
		
		try
		{
			connnection=JDBCUtil.getConnection();
			statement=connnection.prepareStatement(sql);
			statement.setString(1, data.getIp());
			statement.setString(2, data.getTime());
			statement.setString(3, data.getDay());
			statement.setString(4, data.getTraffic());
			statement.setString(5, data.getType());
			statement.setString(6, data.getType_id());
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
	public List<Data> getBigAllList() {
		// TODO Auto-generated method stub
		List<Data> lists=new ArrayList<>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
			 connection=HiveJdbcUtil.getConnection();
			 statement=connection.createStatement();
			 String sql="select ip,time,day,traffic,type,type_id from test";
			 resultset=statement.executeQuery(sql);
			 while(resultset.next())
			 {
				 String ip=resultset.getString("ip");
				 String time=resultset.getString("time");
				 String day=resultset.getString("day");
				 String traffic=resultset.getString("traffic");
				 String type=resultset.getString("type");
				 String id=resultset.getString("type_id");
				 Data data=new Data(ip,time,day,traffic,type,id);
				 lists.add(data);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	
}
