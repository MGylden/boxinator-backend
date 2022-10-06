package com.postgre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.postgre.models.User;
import com.postgre.repositories.UserRepository;

@Service
public class UserService {


	@Autowired
	private UserRepository userRepo;
	
	public ResponseEntity<User> getUserById(Long id){
		HttpStatus httpStatus = null;
		User returnUser = null;
		
		try {
			if((returnUser = userRepo.getReferenceById(id)) != null) {
				httpStatus = HttpStatus.OK;
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}
	
	public ResponseEntity<User> createUser(User newUser){
		HttpStatus httpStatus = null;
		User returnUser = null;
		
		try {
			if(userRepo.existByMail()==false) {
				httpStatus = HttpStatus.OK;
				returnUser = userRepo.saveAndFlush(newUser);
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}
}
