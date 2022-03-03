package com.cotiviti.trs.controller;

import com.cotiviti.trs.model.Schedule;
import com.cotiviti.trs.model.ScheduledFlight;
import com.cotiviti.trs.response.ServiceResponse;
import com.cotiviti.trs.service.FlightService;
import com.cotiviti.trs.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {

	@Autowired
	ScheduledFlightService scheduleFlightService;


	@Autowired
	FlightService flightService;

	@PostMapping("/add")
	public ResponseEntity<?> addSF(@ModelAttribute ScheduledFlight scheduledFlight,
								   @RequestParam(name = "deptDateTime") String departureTime,
								   @RequestParam(name = "arrDateTime") String arrivalTime) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);
		scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
		scheduledFlight.setSchedule(schedule);
		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
		ServiceResponse response = scheduleFlightService.addScheduledFlight(scheduledFlight);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}


	@PutMapping("/modify")
	public ResponseEntity<?> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
		ServiceResponse response =  scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteSF(@RequestParam BigInteger flightId) {
		ServiceResponse response =  scheduleFlightService.removeScheduledFlight(flightId);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<?> viewSF(@RequestParam BigInteger flightId)  {
		ServiceResponse response = scheduleFlightService.viewScheduledFlight(flightId);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}


	@GetMapping("/viewAll")
	public ResponseEntity<?> viewAllSF() {
		ServiceResponse response =  scheduleFlightService.viewAllScheduledFlights();
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}
	

}
