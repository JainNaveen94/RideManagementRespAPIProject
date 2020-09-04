package com.nagarro.ride.services;

import com.nagarro.ride.model.ResponseModel;

public interface RideService {

	ResponseModel rideBookRequest(String source, String destination);

}
