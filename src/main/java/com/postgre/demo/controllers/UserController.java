package com.postgre.demo.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgre.demo.models.User;
import com.postgre.demo.repositories.UserRepository;
import com.postgre.demo.services.UserService;

import static com.postgre.demo.controllers.ControllerHelper.BASE_URI_V1;


@RestController
@RequestMapping(path = BASE_URI_V1 + "Users/")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	/*
	 * @GetMapping("AllUsers2") public List<User> getAllUsers2(){ return
	 * (List<User>) this.userRepo.findAll(); }
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping()
	public ResponseEntity<User> addUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id")Long id){
		return userService.deleteUser(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User>updateUser(@PathVariable(value="id")Long id, @Validated @RequestBody User newUser){
		return userService.updateUser(newUser, id);
	}
}