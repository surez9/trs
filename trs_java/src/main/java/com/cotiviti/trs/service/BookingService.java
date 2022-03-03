package com.cotiviti.trs.service;

import com.cotiviti.trs.model.Booking;
import com.cotiviti.trs.response.ServiceResponse;
import java.math.BigInteger;

public interface BookingService {

	public ServiceResponse createBooking(Booking newBooking);

	public ServiceResponse updateBooking(Booking newBooking);

	public ServiceResponse deleteBooking(Integer bookingId);

	public ServiceResponse displayAllBooking();

	public ServiceResponse findBookingById(Integer bookingId);
}
