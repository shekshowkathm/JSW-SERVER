package com.jsw.jswserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "coleakages")
public class COleakage {
	
	
	@Id
	private String id;
	private String location;
	private String date_time;
	private String co_concentration;
	private String sensor_reading;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getCo_concentration() {
		return co_concentration;
	}
	public void setCo_concentration(String co_concentration) {
		this.co_concentration = co_concentration;
	}
	public String getSensor_reading() {
		return sensor_reading;
	}
	public void setSensor_reading(String sensor_reading) {
		this.sensor_reading = sensor_reading;
	}
	@Override
	public String toString() {
		return "COleakage [id=" + id + ", location=" + location + ", date_time=" + date_time + ", co_concentration="
				+ co_concentration + ", sensor_reading=" + sensor_reading + "]";
	}
	
	

}
