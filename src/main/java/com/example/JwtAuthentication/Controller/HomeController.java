package com.example.JwtAuthentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtAuthentication.Repository.UserRepository;

@RequestMapping("home")
@RestController
public class HomeController {
	

	@GetMapping("/")
	public String greet() {
		return "home page is accessible";
	}
}
