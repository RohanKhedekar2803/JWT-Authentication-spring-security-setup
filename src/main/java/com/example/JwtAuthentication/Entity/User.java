package com.example.JwtAuthentication.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "users")
public class User {

	private ObjectId id;
	
	private String username;
	
	private String password;
	
	private String role;
	
	private int age;
	
	private String info;
	
}
