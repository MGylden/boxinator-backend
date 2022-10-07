package com.postgre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgre.models.User;
import com.postgre.services.UserService;

import lombok.*;

@RestController
@RequestMapping(path = "api/v1/Users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping()
	public ResponseEntity<User> addUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	}

//	@GetMapping("/")
//	public ResponseEntity<T>

}
