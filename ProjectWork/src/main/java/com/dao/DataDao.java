package com.dao;

import java.util.List;

import com.entity.Data;
import com.entity.DataNumber;

public interface DataDao {
	
	public List<Data> getBigAllList();
	
	public List<Data> getAllList();

	public void  add(Data data);
}
