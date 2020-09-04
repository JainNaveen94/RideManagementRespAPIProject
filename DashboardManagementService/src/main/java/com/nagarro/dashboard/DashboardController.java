package com.nagarro.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dashboard.model.ResponseModel;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${app.rideServiceUrl}")
	private String uri;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ridebook/{source}/to/{destination}")
	public ResponseEntity<ResponseModel> rideBookRequest(@PathVariable String source,
			@PathVariable String destination) {
		try {
			ResponseModel response = this.restTemplate.exchange(uri + "ride/book/" + source + "/to/" + destination,
					HttpMethod.GET, null, new ParameterizedTypeReference<ResponseModel>() {
					}).getBody();
			if (response != null) {
				logger.warn("Ride is Booked");
				return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
			} else {
				logger.warn("Ride is Not Booked Due to Service is down");
				throw new RuntimeException();
			}
		} catch (Exception exception) {
			throw new RuntimeException();
		}

	}

}
