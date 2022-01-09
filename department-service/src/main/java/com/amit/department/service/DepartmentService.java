package com.amit.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.department.entity.Department;
import com.amit.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {

		log.info("Start of DepartmentService.saveDepartment");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("Start of DepartmentService.findDepartmentById");

		return departmentRepository.findByDepartmentId(departmentId);
	}

}
