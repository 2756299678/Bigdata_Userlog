package com.dao;

import java.util.List;

import com.entity.DataTraffic;

public interface DataTrafficDao {

	public List<DataTraffic> getfromHive();
	
	public List<DataTraffic> getfromData();
	
	public void add(DataTraffic data);
	
	public List<DataTraffic> getall();
	
	public void clean();
	
}