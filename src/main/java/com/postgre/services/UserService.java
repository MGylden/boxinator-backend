package com.postgre.services;

import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.postgre.models.Shipments;
import com.postgre.models.User;
import com.postgre.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public ResponseEntity<User> getUserById(Long id) {
		HttpStatus httpStatus = null;
		User returnUser = null;

		try {
			if ((returnUser = userRepo.getReferenceById(id)) != null) {
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}

	public ResponseEntity<User> createUser(User newUser) {
		HttpStatus httpStatus = null;
		User returnUser = null;

		try {
			if (userRepo.existByMail() == false) {
				returnUser = userRepo.saveAndFlush(newUser);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}

	public ResponseEntity<User> deleteUser(Long id) {
		HttpStatus httpStatus = null;
		User returnUser = null;

		try {
			if((returnUser = userRepo.getReferenceById(id)) != null) {
				userRepo.deleteById(id);
				httpStatus = HttpStatus.OK;
			}else {
				httpStatus = HttpStatus.BAD_GATEWAY;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}
	
	public ResponseEntity <Set<User>> getAllUsers(){
		Set<User> returnUser = null;
		HttpStatus httpStatus = null;
		
		try {
			returnUser = (Set<User>) userRepo.findAll();
			if (returnUser.isEmpty()) {
				httpStatus = HttpStatus.NOT_FOUND;
			}else {
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			System.out.println("The house is on fire...");
			System.out.println(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}
	
	public ResponseEntity<User> updateUser(User newUser, Long id){
		HttpStatus httpStatus = null;
		User returnUser = null;
		
		try {
			if((returnUser = userRepo.getReferenceById(id))!= null) {
				newUser = (User)HelperService.partialUpdate(httpStatus, returnUser);
				returnUser = userRepo.saveAndFlush(newUser);
				httpStatus = HttpStatus.OK;
			}else {
				httpStatus = HttpStatus.BAD_GATEWAY;
			}
		} catch (BeansException e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());		}
		return new ResponseEntity<>(returnUser, httpStatus);
	}
}
