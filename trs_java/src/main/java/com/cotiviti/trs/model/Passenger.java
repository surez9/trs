package com.cotiviti.trs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trs_passenger")
public class Passenger {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigInteger pnrNumber;
    private String passengerName;
    private int passengerAge;
    private Double luggage;

}
