package com.example.JwtAuthentication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.JwtAuthentication.Entity.User;
import com.example.JwtAuthentication.Repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userrepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userrepository.findByUsername(username);
		if(user!=null) {
			return new CustomUserDetails(user);
		}
		 return null;
		
	}

}
