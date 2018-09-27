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
		//将文件上传到hdfs上
		try {
			Importdata("F://Program Files/feiq/Recv Files/2minlion.log","/test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将文件传到hdfs上
	 * @param localPath
	 * @param HdfsPath
	 * @throws Exception
	 */
	public static void Importdata(String localPath,String HdfsPath) throws Exception
	{
		//将数据传到HDFS上
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
	 * 进行Map存储数据清洗
	 * @param dataPath
	 * @param resultPath
	 * @throws Exception
	 */
	public void importdataToHDFS() throws Exception
	{
		//进行Map存储数据
		MyJob myJob=new MyJob();
		ToolRunner.run(myJob, null);
		
	}
	/**
	 * 将清洗的数据加载到data
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
	 * 将清洗的数据加载到datanumber里
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
	 * 将清洗的数据加载到datatraffic里
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
