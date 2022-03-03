package com.cotiviti.trs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @project: trs
 * @author: Suresh Bhandari
 **/
@SpringBootApplication
public class TrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrsApplication.class, args);
	}

}
