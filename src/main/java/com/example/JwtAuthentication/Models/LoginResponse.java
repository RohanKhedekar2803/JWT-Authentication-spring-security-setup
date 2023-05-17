package com.example.JwtAuthentication.Models;

import com.example.JwtAuthentication.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
	private boolean success;
	private Errorfeild error;
	private User user;
	private String token;
}
