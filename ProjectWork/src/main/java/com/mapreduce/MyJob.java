package com.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MyJob extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		MyJob myJob=new MyJob();
		ToolRunner.run(myJob, null);
	}
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.72.10:9000");
		Job job=Job.getInstance(conf);
		job.setJarByClass(MyJob.class);
		
		//设置map相关参数
		job.setMapperClass(MyMap.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		//FileInputFormat.addInputPath(job, new Path("/hadoop/browser"));
		//FileOutputFormat.setOutputPath(job, new Path("/hadoop/browserout"));
		
		FileInputFormat.addInputPath(job, new Path("/test"));
		FileOutputFormat.setOutputPath(job, new Path("/hadoop/test"));
		
		job.waitForCompletion(true);
		return 0;
	}

}
