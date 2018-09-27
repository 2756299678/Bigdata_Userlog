package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.dao.DataNumberDao;
import com.dao.DataTrafficDao;
import com.dao.impl.DataNumberimpl;
import com.dao.impl.DataTrafficimpl;
import com.entity.DataNumber;
import com.entity.DataTraffic;

@SuppressWarnings("serial")
public class DataUseServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse resp)throws 
	ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		String method=req.getParameter("method");
		if("number".equals(method))
		{
			returnNumber(req,resp);
		}
		if("traffic".equals(method))
		{
			returnTraffic(req,resp);
		}
	}
	
	private void returnTraffic(HttpServletRequest req, HttpServletResponse resp)throws 
	IOException,ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("查询Traffic");
		DataTrafficDao trafficDao=new DataTrafficimpl();
		List<DataTraffic> datas=trafficDao.getall();
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println(JSONObject.toJSONString(datas));
		out.print(JSONObject.toJSONString(datas));
		out.flush();
		out.close();	
	}

	public void returnNumber(HttpServletRequest req, HttpServletResponse resp)throws 
	IOException,ServletException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("查询Number");
		
		DataNumberDao numberDao=new DataNumberimpl();
		//提取mysql中的数据存储到json中
		List<DataNumber> lists=numberDao.getListAll();
		//System.out.println(lists);
		//JSONObject.toJSONString(lists);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println(JSONObject.toJSONString(lists));
		out.print(JSONObject.toJSONString(lists));
		out.flush();
		out.close();	
	}
	
}
