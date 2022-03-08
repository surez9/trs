package com.cotiviti.trs.service;

import com.cotiviti.trs.dto.ScheduleDto;
import com.cotiviti.trs.model.Flight;
import com.cotiviti.trs.model.Schedule;
import com.cotiviti.trs.model.ScheduledFlight;
import com.cotiviti.trs.repository.FlightRepository;
import com.cotiviti.trs.repository.ScheduleRepository;
import com.cotiviti.trs.repository.ScheduledFlightRepository;
import com.cotiviti.trs.response.ServiceResponse;
import com.google.gson.Gson;
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
	FlightRepository flightRepository;

	@Autowired
	BookingService bookingService;


//	public ServiceResponse addScheduledFlight(ScheduledFlight scheduledFlight) {
//		 scheduledFlightRepository.save(scheduledFlight);
//		ServiceResponse response=new ServiceResponse(true,"Schedule Successfully saved");
//		return  response;
//	}
	public ServiceResponse addScheduledFlight(ScheduleDto scheduleDto) {

		ScheduledFlight scheduledFlight = new ScheduledFlight();
		scheduledFlight.setFlight(flightRepository.findByFlightNo(scheduleDto.getFlightNo()).get());
		scheduledFlight.setSchedule(scheduleRepository.findById(scheduleDto.getScheduleId()).get());
		scheduledFlight.setAvailableSeats(scheduleDto.getAvailableSeats());
		scheduledFlightRepository.save(scheduledFlight);
		ServiceResponse response=new ServiceResponse(true,"Schedule Successfully saved");
		return  response;
	}

	public ServiceResponse modifyScheduledFlight(ScheduleDto scheduleFlight) {
		ScheduledFlight updateScheduleFlight = scheduledFlightRepository.findById(scheduleFlight.getScheduleFlightId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		updateScheduleFlight.setFlight(flightRepository.findByFlightNo(scheduleFlight.getFlightNo()).get());
		updateScheduleFlight.setSchedule(scheduleRepository.findById(scheduleFlight.getScheduleId()).get());
		scheduledFlightRepository.save(updateScheduleFlight);
		ServiceResponse response=new ServiceResponse(true,"Schedule Successfully updated");
		return  response;
	}


	public ServiceResponse removeScheduledFlight(Integer flightId)  {
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

	public ServiceResponse viewScheduledFlight(Integer flightId)  {
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
