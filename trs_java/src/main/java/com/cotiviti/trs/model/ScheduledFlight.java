package com.cotiviti.trs.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class ScheduledFlight {

	@Id
	@Column(name = "schedule_flight_id")
	private BigInteger scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;

	@Column(name = "available_seats")
	private Integer availableSeats;

	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

}
