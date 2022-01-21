package com.renji.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renji.bank.model.User;
import com.renji.bank.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class BankController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		System.out.println("Inside getAllUsers");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping({ "/{userId}" })
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		System.out.println("Inside getUser " +userId);
		User user=userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		System.out.println("Inside saveUser "+user.getName());
		User newUser=userService.saveUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PutMapping({ "/{userId}" })
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		System.out.println("Inside updateUser "+userId);
		User newUser=userService.updateUser(userId,user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	@DeleteMapping({ "/{userId}" })
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		System.out.println("Inside deleteUser "+userId);
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted successfully.",HttpStatus.OK);
	}
}
