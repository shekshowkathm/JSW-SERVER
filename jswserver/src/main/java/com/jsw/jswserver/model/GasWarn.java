package com.jsw.jswserver.model;



import org.springframework.data.annotation.Id;

public class GasWarn {
	@Id
	private String id;
	private String location;
	private String ppm;
	private String time;
	private String date;
	private String sensorReading;
	private String email;
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
	public String getPpm() {
		return ppm;
	}
	public void setPpm(String ppm) {
		this.ppm = ppm;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSensorReading() {
		return sensorReading;
	}
	public void setSensorReading(String sensorReading) {
		this.sensorReading = sensorReading;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "GasWarn [id=" + id + ", location=" + location + ", ppm=" + ppm + ", time=" + time + ", date=" + date
				+ ", sensorReading=" + sensorReading + ", email=" + email + "]";
	}

	
	
	
	

	
	
		
	

}
