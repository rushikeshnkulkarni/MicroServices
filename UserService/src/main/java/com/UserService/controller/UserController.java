package com.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.entity.User;
import com.UserService.services.userservice;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	userservice userservice;

//	@PostMapping
//	ResponseEntity<User> createuser(@RequestBody User user) {
//		System.out.println(user.getName());
//		User user2 = userservice.saveuUser(user);
//		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
//	}
	
	@PostMapping
	ResponseEntity<User> createuser(@RequestBody User user) {
		User user2 = userservice.saveuUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<User> getuser (@PathVariable String id){	
		User user = userservice.getUser(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
	@GetMapping
	ResponseEntity<List<User>> getallusers(){
		
		List<User> user = userservice.users();
		
		return ResponseEntity.ok(user);
	}
}
