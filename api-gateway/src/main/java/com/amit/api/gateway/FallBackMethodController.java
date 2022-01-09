package com.amit.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallback")
	public String userServiceFallbackMethod() {
		return "User service is down/working slow. Please try again...";

	}

	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallbackMethod() {
		return "Department service is down/working slow. Please try again...";

	}
}
