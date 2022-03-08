package com.cotiviti.trs.repository;

import com.cotiviti.trs.model.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Integer> {

}
