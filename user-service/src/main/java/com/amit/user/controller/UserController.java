package com.amit.user.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.user.entity.User;
import com.amit.user.service.UserService;
import com.amit.user.vo.ResponseTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Start of UserController.getUserWithDepartment");
		return service.findUserWithDepartment(userId);
	}

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Start of UserController.saveUser");
		return service.saveUser(user);
	}
}
