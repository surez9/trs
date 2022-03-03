package com.cotiviti.trs.service;

import com.cotiviti.trs.model.Booking;
import com.cotiviti.trs.repository.BookingRepository;
import com.cotiviti.trs.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public ServiceResponse createBooking(Booking newBooking) {
				bookingRepository.save(newBooking);
				ServiceResponse response=new ServiceResponse(true,"Booking Created!!!!!");
				return  response;

	}



	@Override
	public ServiceResponse updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingRepository.findById(changedBooking.getBookingId());
		bookingRepository.save(changedBooking);
		ServiceResponse response=new ServiceResponse(true,"Booking updated!!!!!");
		return  response;
	}

	public ServiceResponse deleteBooking(Integer bookingId) {

		//Optional<Booking> findBookingById = bookingRepository.findById(bookingId);

		bookingRepository.deleteById(bookingId);
		ServiceResponse response=new ServiceResponse(true,"Booking delted!!!!!");
		return  response;

	}

	@Override
	public ServiceResponse displayAllBooking() {

		List<Booking> list = (List<Booking>) bookingRepository.findAll();
		Map<String,Object> result= new HashMap<>();
		result.put("booking",list);
		ServiceResponse response=new ServiceResponse(true,result);
		return  response;
	}

	public ServiceResponse findBookingById(Integer bookingId) {
		Optional<Booking> findById = bookingRepository.findById(bookingId);
		if (findById.isPresent()) {
			Booking findBooking = findById.get();
			Map<String, Object> result = new HashMap<>();
			result.put("booking", findBooking);
			ServiceResponse response = new ServiceResponse(true, result);
			return response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "Result not foung");
			return response;
		}
	}
}
