package com.cotiviti.trs.repository;

import com.cotiviti.trs.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
