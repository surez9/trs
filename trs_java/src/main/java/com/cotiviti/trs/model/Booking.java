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
@Table(name = "trs_booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;
    private String bookingDate;
    private int noOfPassengers;

}
