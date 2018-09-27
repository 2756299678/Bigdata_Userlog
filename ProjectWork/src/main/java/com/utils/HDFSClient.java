package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class HDFSClient {
	public static void main(String[] args) {
		 write();
	}
	public static void append(){
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.72.10:9000");
		try {
			FileSystem fs=FileSystem.get(conf);
			FSDataOutputStream outpustream = fs.append(new Path("/hadoop/abc.txt"));
			outpustream.writeBytes("abcdefg");
			outpustream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void write(){
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.72.10:9000");
		try {
			FileSystem fs=FileSystem.get(conf);
			FSDataOutputStream outputStream = fs.create(new Path("/hadoop/abc.txt"));
			outputStream.writeBytes("abcdefgh123");
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read(){
		
		Configuration conf=new Configuration();
		
		conf.set("fs.defaultFS", "hdfs://192.168.72.10:9000");
		try {
			FileSystem fs=FileSystem.get(conf) ;
			FSDataInputStream inputstream = fs.open(new Path("/hadoop/abc.txt"));
			InputStreamReader isr=new InputStreamReader(inputstream);
			BufferedReader br=new BufferedReader(isr);
			String str=br.readLine();
		
			System.out.println(str);
			
			br.close();
			isr.close();
			inputstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
