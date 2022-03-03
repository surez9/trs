package com.cotiviti.trs.controller;

import com.cotiviti.trs.model.Flight;
import com.cotiviti.trs.response.ServiceResponse;
import com.cotiviti.trs.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		ServiceResponse response= flightService.addFlight(flight);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/allFlight")
	public ResponseEntity<?> viewAllFlight() {
		ServiceResponse response=  flightService.viewAllFlight();
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<?> viewFlight(@PathVariable("id") BigInteger flightNo) {
		ServiceResponse response=  flightService.viewFlightById(flightNo);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PutMapping("/updateFlight")
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {
		ServiceResponse response=flightService.modifyFlight(flight);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<?> removeFlight(@PathVariable("id") BigInteger flightNo) {
		ServiceResponse response=flightService.removeFlight(flightNo);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}
}
