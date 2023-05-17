package com.example.JwtAuthentication.Repository;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.JwtAuthentication.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{

	User findByUsername(String username);

	User save(User user);

	

}
