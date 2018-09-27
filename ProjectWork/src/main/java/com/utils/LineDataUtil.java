package com.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

public class LineDataUtil {

	public String lineToID(String line)
	{
		String str  = line.substring(StringUtils.ordinalIndexOf(line,"\"",5)+1, StringUtils.ordinalIndexOf(line,"\"",6));
		String type = "null";
		String id = "null";
		
		if(str != null)
		{
			if(str.contains("video"))
			{
				type = "video";
				id = str.substring(str.indexOf("video"));
				String str1 ,str2;
				if(id.contains("/"))
				{
					str1 = id.substring(id.indexOf("/")+1);
					if (str1.contains("?"))
					{
						str2 = str1.substring(0,str1.indexOf("?"));
						id =str2;
						
					}
					else if (str1.contains("/"))
					{
						str2 = str1.substring(0,str1.indexOf("/"));
						id =str2;
						
					}
					else
						id = str1;
				}
				else
					id = "null";
				
			}
			else if (str.contains(".com/article"))
			{
				type = "article";
				id = str.substring(str.indexOf("article"));
				String str1,str2 ;
				if(id.contains("/"))
				{
					str1 = id.substring(id.indexOf("/")+1);
					if (str1.contains("?"))
					{
						str2 = str1.substring(0,str1.indexOf("?"));
						id =str2;
						
					}
					else if (str1.contains("/"))
					{
						str2 = str1.substring(0,str1.indexOf("/"));
						id =str2;
						
					}
					else
						id = str1;
					
				}
				else
					id = "null";
				
			}
				
		}
		
		//System.out.println(address+"\t"+time+"\t"+day+"\t"+traffic+"\t"+type+"\t"+id);
		
		return id;
	}
	
	public String lineToData(String line)
	{
		String ip = line.substring(0, line.indexOf(" "));
		String time = line.substring(line.indexOf("[")+1, line.indexOf("]"));
		String timer=time.replace(" ", "");
		String day =  time.substring(0,time.indexOf("/"));
		String trafficstr =line.substring(StringUtils.ordinalIndexOf(line,"\"",2)+2, StringUtils.ordinalIndexOf(line,"\"",3));
		String traffic = trafficstr.substring(trafficstr.indexOf(" ")+1);
		String str  = line.substring(StringUtils.ordinalIndexOf(line,"\"",5)+1, StringUtils.ordinalIndexOf(line,"\"",6));
		String type = "null";
		String id = "null";
		
		if(str != null)
		{
			if(str.contains("video"))
			{
				type = "video";
				id = str.substring(str.indexOf("video"));
				String str1 ,str2;
				if(id.contains("/"))
				{
					str1 = id.substring(id.indexOf("/")+1);
					if (str1.contains("?"))
					{
						str2 = str1.substring(0,str1.indexOf("?"));
						id =str2;
						
					}
					else if (str1.contains("/"))
					{
						str2 = str1.substring(0,str1.indexOf("/"));
						id =str2;
						
					}
					else
						id = str1;
				}
				else
					id = "null";
				
			}
			else if (str.contains(".com/article"))
			{
				type = "article";
				id = str.substring(str.indexOf("article"));
				String str1,str2 ;
				if(id.contains("/"))
				{
					str1 = id.substring(id.indexOf("/")+1);
					if (str1.contains("?"))
					{
						str2 = str1.substring(0,str1.indexOf("?"));
						id =str2;
						
					}
					else if (str1.contains("/"))
					{
						str2 = str1.substring(0,str1.indexOf("/"));
						id =str2;
						
					}
					else
						id = str1;
					
				}
				else
					id = "null";
				
			}
				
		}
		
		//System.out.println(address+"\t"+time+"\t"+day+"\t"+traffic+"\t"+type+"\t"+id);
		return ip+"\t"+timer+"\t"+day+"\t"+traffic+"\t"+type;
	}
}
