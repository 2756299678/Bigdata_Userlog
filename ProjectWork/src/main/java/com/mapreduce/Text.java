package com.mapreduce;

import org.apache.commons.lang3.StringUtils;

import com.utils.LineDataUtil;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line="10.100.0.1 - - [10/Nov/2016:00:01:02 +0800] \"HEAD / HTTP/1.1\" 301 0 \"117.121.101.40\" \"-\" - \"curl/7.19.7 (x86_64-redhat-linux-gnu) libcurl/7.19.7 NSS/3.16.2.3 Basic ECC zlib/1.2.3 libidn/1.18 libssh2/1.4.2\" \"-\" - - - 0.000";
		LineDataUtil linutil=new LineDataUtil();
		String data=linutil.lineToData(line);
		
		System.out.println(data);
	}

}
