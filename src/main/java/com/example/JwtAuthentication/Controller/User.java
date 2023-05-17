package com.example.JwtAuthentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtAuthentication.Models.LoginRequest;
import com.example.JwtAuthentication.Models.LoginResponse;
import com.example.JwtAuthentication.Services.CustomUserDetails;
import com.example.JwtAuthentication.Services.UserServices;
import com.example.JwtAuthentication.Services.jwtUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class User {
	
	@Autowired
	private jwtUtils jwtutils;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private UserServices userservices;

	@GetMapping("/greet")
	public String greetuser() {
		log.info("/ fired");
		return "user greetings is accessible";
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws Exception{

		LoginResponse response= userservices.loginuser(loginRequest.getUsername(),loginRequest.getPassword());
		
		if(response.isSuccess()) {
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
		}
		
		return new ResponseEntity<LoginResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
