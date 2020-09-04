package com.nagarro.ride.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.ride.model.DriverModel;
import com.nagarro.ride.model.ResponseModel;
import com.nagarro.ride.model.RideModel;

@Service
public class RideServiceImpl implements RideService {
	
	@Value("${app.driverServiceUrl}")
	private String uri;
	
	@Autowired
	RestTemplate restTemplate;


	@Override
	public ResponseModel rideBookRequest(String source, String destination) {
		try {
			ResponseEntity<DriverModel> response = this.restTemplate.exchange(uri + "driverservice/getdriver", HttpMethod.GET, null, new ParameterizedTypeReference<DriverModel>() {
			});
			DriverModel driverDetails = response.getBody();
			RideModel rideDetail = new RideModel(source, destination, new Date().toString(), driverDetails.getCarType());
			return new ResponseModel(rideDetail, driverDetails);
		} catch(Exception exception) {
			throw new RuntimeException("Driver Service Down");
		}
	}

}
