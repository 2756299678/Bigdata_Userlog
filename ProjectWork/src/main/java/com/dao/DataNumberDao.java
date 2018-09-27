package com.dao;

import java.util.List;

import com.entity.DataNumber;

public interface DataNumberDao {

	//hive大数据库操作查询统计条数
	public List<DataNumber> getListBigBynumber();
	
	//hive操作查询统计条数
	public List<DataNumber> getListBynumber();

	//mysql操作存入数据库
	public void add(DataNumber data);
	
	//mysql操作获取所有数据
	public List<DataNumber> getListAll();
}
