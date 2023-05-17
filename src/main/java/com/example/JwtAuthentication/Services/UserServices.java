package com.example.JwtAuthentication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.JwtAuthentication.Entity.User;
import com.example.JwtAuthentication.Models.Errorfeild;
import com.example.JwtAuthentication.Models.LoginResponse;
import com.example.JwtAuthentication.Repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServices {

	@Autowired
	private UserRepository userrepository;
	
	
	@Autowired
	private jwtUtils jwtutils;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	
	public LoginResponse loginuser(String Username, String password) throws Exception{
		String token=null;
		User user=null;
			try {
			log.info("extracting user");
			
			 authenticationmanager.authenticate(
						new UsernamePasswordAuthenticationToken(Username,password)
						);
			 user= userrepository.findByUsername(Username);
			 log.info("generating token");
			 token =jwtutils.generateToken(Username);
				log.info("generated token");
	//			return token;
			
			}catch(Exception e){
				log.info("user not found");
		
				return new LoginResponse(false,new Errorfeild("400","invalid credentials"),null,null);
				
			}
		return new LoginResponse(true,null,user,token);
	}
}
