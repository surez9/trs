package com.cotiviti.trs.service;

import com.cotiviti.trs.model.Flight;
import com.cotiviti.trs.repository.FlightRepository;
import com.cotiviti.trs.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightRepository flightRepository;


	@Override
	public ServiceResponse addFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
			if (!findById.isPresent()) {
				flightRepository.save(flight);
				ServiceResponse response = new ServiceResponse(true, "Flight Successfully saved");
				return response;
			} else {
				ServiceResponse response = new ServiceResponse(false, "Schedule didn't saved");
				return response;
			}

	}


	@Override
	public ServiceResponse viewAllFlight() {
		List<Flight>list = (List<Flight>) flightRepository.findAll();
		Map<String,Object> result = new HashMap<>();
		result.put("flight",list);
		ServiceResponse response=new ServiceResponse(true,result);
		return  response;
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepository.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public ServiceResponse viewFlightById(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepository.findById(flightNumber);
		if (findById.isPresent()) {
			Map<String, Object> result = new HashMap<>();
			result.put("flight", findById);
			ServiceResponse response = new ServiceResponse(true, result);
			return response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "NOdata found");
			return response;
		}
	}
	@Override
	public ServiceResponse modifyFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightRepository.save(flight);
			ServiceResponse response = new ServiceResponse(true, "Data updated");
			return response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "No data updated");
			return response;
		}

	}


	public ServiceResponse removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepository.findById(flightNumber);
		if (findById.isPresent()) {
			flightRepository.deleteById(flightNumber);
			ServiceResponse response = new ServiceResponse(true, " data deleted");
			return response;
		} else {

			ServiceResponse response = new ServiceResponse(false, "No data delted");
			return response;
		}
	}
}
