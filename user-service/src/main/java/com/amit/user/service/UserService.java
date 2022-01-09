package com.amit.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amit.user.entity.User;
import com.amit.user.repository.UserRepository;
import com.amit.user.vo.Department;
import com.amit.user.vo.ResponseTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseTemplate findUserWithDepartment(Long userId) {
		log.info("Start of UserService.getUserWithDepartment");
		ResponseTemplate rt = new ResponseTemplate();

		User user = repository.findByUserId(userId);
		
		log.info("retried user");

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);

		log.info("retried department");

		rt.setDepartment(department);
		rt.setUser(user);
		log.info("End of UserService.getUserWithDepartment");

		return rt;
	}

	public User saveUser(User user) {
		log.info("Start of UserService.saveUser");
		return repository.save(user);
	}

}
