package com.dao;

import java.util.List;

import com.entity.DataNumber;

public interface DataNumberDao {

	//hive�����ݿ������ѯͳ������
	public List<DataNumber> getListBigBynumber();
	
	//hive������ѯͳ������
	public List<DataNumber> getListBynumber();

	//mysql�����������ݿ�
	public void add(DataNumber data);
	
	//mysql������ȡ��������
	public List<DataNumber> getListAll();
}
