package com.nagarro.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.driver.model.DriverModel;
import com.nagarro.driver.service.DriverManagementServiceInt;

@RestController
@RequestMapping("/driverservice")
public class DriverManagementController {
	
	@Autowired
	private DriverManagementServiceInt driverManagementService;
	
	@GetMapping("/getdriver")
	public ResponseEntity<DriverModel> getDriverDetailByID() {
		DriverModel driver = this.driverManagementService.getDriverDetailByID();
		if(driver != null) {
			return new ResponseEntity<DriverModel>(driver, HttpStatus.OK);
		} else {
			throw new RuntimeException("Currently Driver Service is Down");
		}
	}

}
