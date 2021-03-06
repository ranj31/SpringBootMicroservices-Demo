package com.ranjan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ranjan.demo.model.Employee;
import com.ranjan.demo.repository.EmployeeRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ranjan.demo.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
	}
	
	@Bean
	EmployeeRepository repository() {
		EmployeeRepository repository = new EmployeeRepository();
		repository.add(new Employee(101L,1L, 501L, "Sanjoy Moni", 34, "Analyst"));
		repository.add(new Employee(102L,1L, 501L, "Rajen Chatterjee", 37, "Manager"));
		repository.add(new Employee(103L,2L, 601L, "Vijoy Chakroborty", 26, "Developer"));
		repository.add(new Employee(104L,1L, 601L, "Sachidanand Dusad", 39, "Analyst"));		
		repository.add(new Employee(105L,3L, 601L, "Mukesh Kumar", 27, "Developer"));
		repository.add(new Employee(106L,4L, 701L, "Ramkrishna Chatterjee", 38, "Developer"));		
		repository.add(new Employee(107L,3L, 801L, "Raksha Bhadani", 34, "Developer"));
		repository.add(new Employee(108L,1L, 901L, "Debolina Chaterjee", 30, "Manager"));
		repository.add(new Employee(109L,1L, 701L, "Maytree Malik", 25, "Developer"));
		repository.add(new Employee(110L,3L, 701L, "Ranjan Chaudhary", 30, "Developer"));
		return repository;
	}

}

