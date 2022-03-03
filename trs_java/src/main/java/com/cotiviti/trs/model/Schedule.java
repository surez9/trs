package com.cotiviti.trs.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/

@Data
@Entity
@Table(name = "trs_schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_Id")
	private BigInteger scheduleId;

	@Column(name = "departure_date")
	private String deptDateTime;

	@Column(name = "arrival_date")
	private String arrDateTime;


}
