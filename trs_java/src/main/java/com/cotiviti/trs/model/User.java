package com.cotiviti.trs.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
@Entity
@Data
@Table(name = "trs_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String username; 
	private String password;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "trs_user_role")
	private Collection<Role> role = new ArrayList<>();

}
