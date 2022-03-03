package com.cotiviti.trs.repository;

import com.cotiviti.trs.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FlightRepository extends JpaRepository<Flight,BigInteger> {

}
