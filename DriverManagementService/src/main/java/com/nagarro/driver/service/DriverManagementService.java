package com.nagarro.driver.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.driver.model.DriverModel;

@Service
public class DriverManagementService implements DriverManagementServiceInt {

	@Override
	public DriverModel getDriverDetailByID() {
		return this.getDriverFromDriverList();
	}

	private List<DriverModel> getDriverList() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<DriverModel>> typeReference = new TypeReference<List<DriverModel>>() {
		};
		InputStream input = TypeReference.class.getResourceAsStream("/json/driver.json");
		try {
			return mapper.readValue(input, typeReference);
		} catch (IOException exception) {
			throw new RuntimeException("Driver DB Error");
		}
	}

	private DriverModel getDriverFromDriverList() {
		List<DriverModel> driverList = this.getDriverList();
		if (driverList != null) {
			Random rm = new Random();
			return driverList.get(rm.nextInt(driverList.size()));
		} else {
			throw new RuntimeException("Currently No Driver Available.");
		}
	}

}
