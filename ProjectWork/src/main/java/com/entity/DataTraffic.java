package com.entity;

public class DataTraffic {

	private String type;
	private String type_id;
	private Long traffic;
	
	public DataTraffic() {
		super();
		
	}
	
	public DataTraffic(String type, String type_id, Long traffic) {
		super();
		this.type = type;
		this.type_id = type_id;
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
	public Long getTraffic() {
		return traffic;
	}
	public void setTraffic(Long traffic) {
		this.traffic = traffic;
	} 
	@Override
	public String toString()
	{		
		return type+","+type_id+","+traffic;
	}
	
}
