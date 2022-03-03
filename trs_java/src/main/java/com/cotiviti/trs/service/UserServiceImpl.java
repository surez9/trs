package com.cotiviti.trs.service;

import com.cotiviti.trs.dto.UserDto;
import com.cotiviti.trs.model.User;
import com.cotiviti.trs.repository.UserRepository;
import com.cotiviti.trs.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private final UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		} else {
			log.info("User found in the database: {}", username);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			user.getRole().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			});
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					authorities);
		}
	}

	@Override
	public ServiceResponse verifyLogin(UserDto user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (user.getUsername() != null) {
			User u = userRepo.findByUsername(user.getUsername());
			if (user.getUsername().equalsIgnoreCase(u.getUsername())
					&& encoder.matches(user.getPassword(), u.getPassword())) {
				ServiceResponse response=new ServiceResponse(true,"Login Success");
				return  response;
			} else {
				ServiceResponse response=new ServiceResponse(false,"Password Didn't match");
				return  response;
			}
		} else {
			ServiceResponse response=new ServiceResponse(false,"User not found");
			return  response;
		}
	}

	@Override
	public ServiceResponse createUser(User newUser) {
		return null;
	}

	public ServiceResponse updateUser(User updateUser) {
		Optional<User> findUserById = userRepo.findById(updateUser.getId());
		if (findUserById.isPresent()) {
			userRepo.save(updateUser);
			ServiceResponse response=new ServiceResponse(true,"Update Success");
			return  response;
		} else {
			ServiceResponse response = new ServiceResponse(false, "Update fail Success");
			return response;
		}
	}

	@Override
	public ServiceResponse deleteUser(BigInteger UserId) {
		return null;
	}

	public ServiceResponse deleteUser(long id) {
		Optional<User> findBookingById = userRepo.findById(id);
		if (findBookingById.isPresent()) {
			userRepo.deleteById(id);
			ServiceResponse response = new ServiceResponse(true, "Deleted Success");
			return response;
		} else{
			ServiceResponse response = new ServiceResponse(false, "Delete fail");
			return response;
		}

	}

	public ServiceResponse displayAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userRepo.findAll();
		Map<String,Object> result = new HashMap<>();
		result.put("user",list);
		ServiceResponse response = new ServiceResponse(true, result);
		return response;
	}

	@Override
	public ServiceResponse findUserById(BigInteger userId) {
		return null;
	}

	public ServiceResponse findUserById(long userId) {
		// TODO Auto-generated method stub
		Optional<User> findById = userRepo.findById(userId);

		if (findById.isPresent()) {
			User findUser = findById.get();
			Map<String,Object> result = new HashMap<>();
			result.put("user",findUser);
			ServiceResponse response = new ServiceResponse(true, result);
			return response;
		} else{
			ServiceResponse response = new ServiceResponse(false, "Fail to load");
			return response;
		}
	}


}
