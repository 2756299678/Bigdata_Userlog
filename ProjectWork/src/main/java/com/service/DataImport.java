package com.service;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.ToolRunner;
import org.junit.Test;

import com.dao.DataDao;
import com.dao.DataNumberDao;
import com.dao.DataTrafficDao;
import com.dao.impl.DataDaoimpl;
import com.dao.impl.DataNumberimpl;
import com.dao.impl.DataTrafficimpl;
import com.entity.Data;
import com.entity.DataNumber;
import com.entity.DataTraffic;
import com.mapreduce.MyJob;
import com.utils.HDFSFileUtil;

public class DataImport{

	
	public void mainText()
	{
		//���ļ��ϴ���hdfs��
		try {
			Importdata("F://Program Files/feiq/Recv Files/2minlion.log","/test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���ļ�����hdfs��
	 * @param localPath
	 * @param HdfsPath
	 * @throws Exception
	 */
	public static void Importdata(String localPath,String HdfsPath) throws Exception
	{
		//�����ݴ���HDFS��
		HDFSFileUtil hdfsUtil=new HDFSFileUtil();
		try {
			hdfsUtil.before();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hdfsUtil.putFile(localPath,HdfsPath);
		
		hdfsUtil.destory();
		
	}

	/**
	 * ����Map�洢������ϴ
	 * @param dataPath
	 * @param resultPath
	 * @throws Exception
	 */
	public void importdataToHDFS() throws Exception
	{
		//����Map�洢����
		MyJob myJob=new MyJob();
		ToolRunner.run(myJob, null);
		
	}
	/**
	 * ����ϴ�����ݼ��ص�data
	 */
	public void insertallData(){
		
		DataDao datadao=new DataDaoimpl();
		List<Data> datas=datadao.getBigAllList();
		System.out.println(datas);
		
		for(Data data:datas)
		{
			datadao.add(data);
		}
		/*Data data = new Data("1.119.52.7","10/Nov/2016:01:57:57+0800","10","12541","article","1183");
		DataDao datadao=new DataDaoimpl();
		datadao.add(data);*/
	}

	/**
	 * ����ϴ�����ݼ��ص�datanumber��
	 */
	public void insertDataNumber()
	{
		DataNumberDao numberDao = new DataNumberimpl();
		List<DataNumber> datas=numberDao.getListBigBynumber();
		System.out.println(datas);
		for(DataNumber data:datas)
		{
			numberDao.add(data);
		}
	}
	/**
	 * ����ϴ�����ݼ��ص�datatraffic��
	 */
	@Test
	public void insertDataTraffic()
	{
		DataTrafficDao trafficDao=new DataTrafficimpl();
		List<DataTraffic> datas=trafficDao.getfromHive();
		//List<DataTraffic> datas=trafficDao.getfromData();
		System.out.println(datas);
		trafficDao.clean();
		for(DataTraffic data:datas)
		{
			trafficDao.add(data);
		}
	}
}
