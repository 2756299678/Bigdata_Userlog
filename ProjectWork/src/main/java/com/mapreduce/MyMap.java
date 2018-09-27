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
		//���л�ȡ����
		String line=value.toString();
		//�������ݵķֽ�
		LineDataUtil linutil=new LineDataUtil();
		String data=linutil.lineToData(line);
		//�������ݵ�id
		String id=linutil.lineToID(line);
		
		if(!id.equals("null"))
		{
			context.write(new Text(data), new Text(id));
		}		
	}
}
