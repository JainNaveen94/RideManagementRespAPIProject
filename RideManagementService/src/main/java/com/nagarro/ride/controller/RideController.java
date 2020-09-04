package com.nagarro.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ride.model.ResponseModel;
import com.nagarro.ride.services.RideService;

@RestController
@RequestMapping("/ride")
public class RideController {
	
	@Autowired
	private RideService rideService;
	
	@GetMapping("/book/{source}/to/{destination}")
	public ResponseEntity<ResponseModel> rideBookRequest(@PathVariable String source, @PathVariable String destination) {
		ResponseModel model = this.rideService.rideBookRequest(source, destination);
		if(model != null) {
			return new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
		} else {
			throw new RuntimeException("Ride is not currently Booked");
		}
		
	}

}
