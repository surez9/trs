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
		Optional<Flight> findById = flightRepository.findByFlightNo(flight.getFlightNo());
			if (!findById.isPresent()) {
				flightRepository.save(flight);
				ServiceResponse response = new ServiceResponse(true, "Flight Successfully saved");
				return response;
			} else {
				ServiceResponse response = new ServiceResponse(false, "This Flight is already added!!!");
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
	public ServiceResponse viewFlightById(Long flightNumber) {
		Optional<Flight> findById = flightRepository.findByFlightNo(flightNumber);
		if (findById.isPresent()) {
			Map<String, Object> result = new HashMap<>();
			result.put("flight", findById.get());
			ServiceResponse response = new ServiceResponse(true, result);
			return response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "NO data found");
			return response;
		}
	}
	@Override
	public ServiceResponse modifyFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findByFlightNo(flight.getFlightNo());
		if (findById.isPresent()) {
			flightRepository.save(flight);
			ServiceResponse response = new ServiceResponse(true, "Data updated");
			return response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "No data updated");
			return response;
		}

	}


	public ServiceResponse removeFlight(Long flightNumber) {
		Optional<Flight> findById = flightRepository.findByFlightNo(flightNumber);
		if (findById.isPresent()) {
			flightRepository.deleteByFlightNo(flightNumber);
			ServiceResponse response = new ServiceResponse(true, " data deleted");
			return response;
		} else {

			ServiceResponse response = new ServiceResponse(false, "No data deleted");
			return response;
		}
	}
}
