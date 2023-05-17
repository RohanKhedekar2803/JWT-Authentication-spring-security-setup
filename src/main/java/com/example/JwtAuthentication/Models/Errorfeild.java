package com.example.JwtAuthentication.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errorfeild {
	private String errorcode;
	private String message;
}
