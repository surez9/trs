package com.cotiviti.trs.service;

import com.cotiviti.trs.model.Schedule;
import com.cotiviti.trs.model.ScheduledFlight;
import com.cotiviti.trs.repository.ScheduleRepository;
import com.cotiviti.trs.repository.ScheduledFlightRepository;
import com.cotiviti.trs.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	ScheduledFlightRepository scheduledFlightRepository;

	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	BookingService bookingService;


	public ServiceResponse addScheduledFlight(ScheduledFlight scheduledFlight) {
		 scheduledFlightRepository.save(scheduledFlight);
		ServiceResponse response=new ServiceResponse(true,"Schedule Successfully saved");
		return  response;
	}


	public ServiceResponse modifyScheduledFlight(ScheduledFlight scheduleFlight) {
		ScheduledFlight updateScheduleFlight = scheduledFlightRepository.findById(scheduleFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = scheduleRepository.findById(scheduleFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
		scheduledFlightRepository.save(updateScheduleFlight);
		ServiceResponse response=new ServiceResponse(true,"Schedule Successfully updated");
		return  response;
	}


	public ServiceResponse removeScheduledFlight(BigInteger flightId)  {
		if (flightId == null){
			ServiceResponse response=new ServiceResponse(false,"No data found");
			return  response;
		}
		Optional<ScheduledFlight> scheduleFlight = scheduledFlightRepository.findById(flightId);
		if (!scheduleFlight.isPresent()) {
			ServiceResponse response = new ServiceResponse(false, "No data found");
			return response;
		}
		else {
			scheduledFlightRepository.deleteById(flightId);
			ServiceResponse response=new ServiceResponse(true,"Schedule Deleted");
			return  response;
		}

	}

	public ServiceResponse viewAllScheduledFlights() {
		Iterable<ScheduledFlight> list =  scheduledFlightRepository.findAll();
		Map<String,Object> result = new HashMap<>();
		result.put("flight",list);
		ServiceResponse response=new ServiceResponse(true,result);
		return  response;
	}

	public ServiceResponse viewScheduledFlight(BigInteger flightId)  {
		if (flightId == null) {
			ServiceResponse response = new ServiceResponse(false, "No data found");
			return response;
		}else {
			Optional<ScheduledFlight> scheduleFlight = scheduledFlightRepository.findById(flightId);
			if (!scheduleFlight.isPresent()) {ServiceResponse response = new ServiceResponse(false, "No data found");
				return response;
			}
			else{
				Map<String,Object> result = new HashMap<>();
				result.put("flight",scheduleFlight);
				ServiceResponse response=new ServiceResponse(true,result);
				return  response;
				}
		}
	}

}
