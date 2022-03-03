package com.cotiviti.trs.controller;

import java.math.BigInteger;

import com.cotiviti.trs.model.User;
import com.cotiviti.trs.response.ServiceResponse;
import com.cotiviti.trs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @project: trs
 * @author: Suresh Bhandari
 **/

@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<?> addUser(@RequestBody User newUser) {

		ServiceResponse response = userService.createUser(newUser);
		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/readAllUsers")
	public ResponseEntity<?> readAllUsers() {
		ServiceResponse response = userService.displayAllUser();

		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User updateUser) {

		ServiceResponse response = userService.updateUser(updateUser);

		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@GetMapping("/searchUser/{id}")
	public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {

		ServiceResponse response = userService.findUserById(userId);

		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") BigInteger userId) {

		ServiceResponse response = userService.deleteUser(userId);

		if (response.isSuccess()) {
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(response);
		}
	}
}