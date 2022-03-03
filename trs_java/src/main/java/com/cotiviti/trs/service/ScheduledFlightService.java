package com.cotiviti.trs.service;

import com.cotiviti.trs.model.ScheduledFlight;
import com.cotiviti.trs.response.ServiceResponse;

import java.math.BigInteger;

public interface ScheduledFlightService {
	public ServiceResponse addScheduledFlight(ScheduledFlight scheduledFlight);

	public ServiceResponse modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public ServiceResponse removeScheduledFlight(BigInteger id) ;

	public ServiceResponse viewAllScheduledFlights();

	public ServiceResponse viewScheduledFlight(BigInteger id) ;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}
