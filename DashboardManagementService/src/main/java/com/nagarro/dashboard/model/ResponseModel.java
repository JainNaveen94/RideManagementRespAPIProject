package com.nagarro.dashboard.model;

public class ResponseModel {
	
	private RideModel rideDetails;
	private DriverModel driverDetails;
	
	public ResponseModel() {
		// TODO Auto-generated constructor stub
	}

	public RideModel getRideDetails() {
		return rideDetails;
	}

	public void setRideDetails(RideModel rideDetails) {
		this.rideDetails = rideDetails;
	}

	public DriverModel getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(DriverModel driverDetails) {
		this.driverDetails = driverDetails;
	}

	public ResponseModel(RideModel rideDetails, DriverModel driverDetails) {
		super();
		this.rideDetails = rideDetails;
		this.driverDetails = driverDetails;
	}
	
	

}
