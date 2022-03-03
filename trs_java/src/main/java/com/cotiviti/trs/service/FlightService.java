package com.cotiviti.trs.service;

import com.cotiviti.trs.model.Flight;
import com.cotiviti.trs.response.ServiceResponse;

import java.math.BigInteger;

public interface FlightService {
	public ServiceResponse addFlight(Flight flight);

	public ServiceResponse viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public ServiceResponse modifyFlight(Flight flight);

	public ServiceResponse removeFlight(BigInteger flightNumber);

	ServiceResponse viewFlightById(BigInteger flightNo);
}
