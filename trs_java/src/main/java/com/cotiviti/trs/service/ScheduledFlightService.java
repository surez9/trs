package com.cotiviti.trs.service;

import com.cotiviti.trs.dto.ScheduleDto;
import com.cotiviti.trs.model.ScheduledFlight;
import com.cotiviti.trs.response.ServiceResponse;

import java.math.BigInteger;

public interface ScheduledFlightService {
	public ServiceResponse addScheduledFlight(ScheduleDto scheduledFlight);

	public ServiceResponse modifyScheduledFlight(ScheduleDto scheduledFlight);

	public ServiceResponse removeScheduledFlight(Integer id) ;

	public ServiceResponse viewAllScheduledFlights();

	public ServiceResponse viewScheduledFlight(Integer id) ;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}
