package com.service;

import java.util.List;

import com.dao.DataNumberDao;
import com.dao.impl.DataNumberimpl;
import com.entity.DataNumber;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataNumberDao numberDao=new DataNumberimpl();
		//��ȡmysql�е����ݴ洢��json��
		List<DataNumber> lists=numberDao.getListAll();
		//System.out.println(lists);
		//JSONObject.toJSONString(lists);
		System.out.println(lists);
	}

}
