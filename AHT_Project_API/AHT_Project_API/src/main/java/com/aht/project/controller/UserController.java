package com.aht.project.controller;

import java.util.List;
import java.util.Set;

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

import com.aht.project.entity.User;
import com.aht.project.entity.Role;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.UserRepository;
import com.aht.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserRepository userRepository;
	private UserService userService;

	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<Object> getAll() {
		ServiceResult serviceResult = userService.findAll();
		List<User> users = (List<User>) serviceResult.getData();
		if (users.size() > 0) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/all")
	public Set<Role> getAllRoles() {
		return userRepository.findById(1).get().getRoles();
	}

	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody User user) {

		ServiceResult serviceResult = userService.save(user);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
		ServiceResult serviceResult = userService.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		ServiceResult serviceResult = userService.update(id, user);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
