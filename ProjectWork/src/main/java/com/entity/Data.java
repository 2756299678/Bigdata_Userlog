package com.entity;

public class Data {

	private String ip;
	private String time;
	private String day;
	private String traffic;
	private String type;
	private String type_id;
	
	public Data()
	{
		
	}
	public Data(String ip, String time, String day, String traffic, String type, String type_id) {
		super();
		this.ip = ip;
		this.time = time;
		this.day = day;
		this.traffic = traffic;
		this.type = type;
		this.type_id = type_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	@Override
	public String toString()
	{		
		return ip+","+time+","+day+","+traffic+","+type+","+type_id;
	}
	
}
