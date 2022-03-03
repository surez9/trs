package com.cotiviti.trs.controller;

import com.cotiviti.trs.model.Booking;
import com.cotiviti.trs.response.ServiceResponse;
import com.cotiviti.trs.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired(required= true)
	BookingService bookingService;

	@PostMapping("/createBooking")
	public ResponseEntity<?> addBooking(@RequestBody Booking newBooking) {

		ServiceResponse response=bookingService.createBooking(newBooking);

		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/readAllBooking")
	public ResponseEntity<?> readAllBookings() {

		ServiceResponse response= bookingService.displayAllBooking();
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PutMapping("/updateBooking")
		public ResponseEntity<?> modifyBooking(@RequestBody Booking updateBooking) {

		ServiceResponse response=bookingService.updateBooking(updateBooking);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/searchBooking/{id}")
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") Integer bookingId) {

		ServiceResponse response=bookingService.findBookingById(bookingId);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") Integer bookingId) {

		ServiceResponse response=bookingService.deleteBooking(bookingId);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}
}
