package com.ranjan.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ranjan.demo.model.Employee;


@FeignClient(name = "employee-service")
public interface EmpClient {

	@GetMapping("/department/{departmentId}")
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
	
}
