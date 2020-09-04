package com.nagarro.ride.model;

public class RideModel {
	
	private String origin;
	private String destination;
	private String time;
	private String carType;
	
	public RideModel() {
		// TODO Auto-generated constructor stub
	}

	public RideModel(String origin, String destination, String time, String carType) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.time = time;
		this.carType = carType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	

}
