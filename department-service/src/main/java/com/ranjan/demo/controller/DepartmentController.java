package com.ranjan.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjan.demo.client.EmpClient;
import com.ranjan.demo.model.Department;
import com.ranjan.demo.repository.DepartmentRepository;

@RestController
public class DepartmentController {
private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	EmpClient empClient;	

	@Autowired
	DepartmentRepository repository;
	
	
	
	@Value("${messageDepartment:Hello default}")
	private String messageDepartment;
	
	@RequestMapping ("/message")
	String getMessageDepartment() {
		return this.messageDepartment;
	}
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return repository.add(department);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		LOGGER.info("Department find");
		return repository.findAll();
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}
	
	@GetMapping("/organization/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganization(organizationId);
		/*List<Employee> aList;
		for(Department d :departments) {
			if(d.getId()!=null) {
				aList= employeeClient.findByDepartment(d.getId());
				d.setEmployees(aList);
			}
		}*/
		
		departments.forEach(d -> d.setEmployees(empClient.findByDepartment(d.getId())));
		return departments;
	}

}
