package com.cotiviti.trs.service;

import com.cotiviti.trs.dto.UserDto;
import com.cotiviti.trs.model.User;
import com.cotiviti.trs.response.ServiceResponse;
import org.springframework.http.ResponseEntity;
/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
import java.math.BigInteger;
import java.util.List;

public interface UserService {
	
	ServiceResponse verifyLogin(UserDto user);

	public ServiceResponse createUser(User newUser);

	public ServiceResponse updateUser(User newUser);

	public ServiceResponse deleteUser(BigInteger UserId);

	public ServiceResponse displayAllUser();

	public ServiceResponse findUserById(BigInteger userId);
	
}
