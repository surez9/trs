package com.cotiviti.trs.dto;

import com.cotiviti.trs.model.Flight;
import com.cotiviti.trs.model.Schedule;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
@Data
public class ScheduleDto {
    private Integer scheduleFlightId;
    private Long flightNo;
    private Integer availableSeats;
    private Integer scheduleId;
}
