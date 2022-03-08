package com.cotiviti.trs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalTime;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trs_flight")
public class Flight {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long flightNo;
    private String carrierName;
    private String flightModel;
    private int seatCapacity;
}
