package com.entity;

public class DataNumber {

	private String type;
	private String type_id;
	private int number;
	
	public DataNumber()
	{
		
	}
	public DataNumber(String type, String type_id, int number) {
		super();
		this.type = type;
		this.type_id = type_id;
		this.number = number;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString()
	{		
		return type+","+type_id+","+number;
	}
}
