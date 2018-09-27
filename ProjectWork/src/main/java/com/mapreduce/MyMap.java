package com.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.utils.LineDataUtil;

import java.io.IOException;

public class MyMap extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//按行获取数据
		String line=value.toString();
		//进行数据的分解
		LineDataUtil linutil=new LineDataUtil();
		String data=linutil.lineToData(line);
		//返回数据的id
		String id=linutil.lineToID(line);
		
		if(!id.equals("null"))
		{
			context.write(new Text(data), new Text(id));
		}		
	}
}
