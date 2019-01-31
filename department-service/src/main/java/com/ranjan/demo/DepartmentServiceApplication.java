package com.ranjan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ranjan.demo.model.Department;
import com.ranjan.demo.repository.DepartmentRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ranjan.demo.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Department API").description("Documentation Department API v1.0").build());
	}
	
	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(501L,1L, "Development"));
		repository.add(new Department(601L,2L, "Operations"));
		repository.add(new Department(701L,3L, "HR"));
		repository.add(new Department(801L,4L, "Services"));
		repository.add(new Department(901L,1L, "Marketting"));
		
		/*repository.add(new Department(501L,2L, "Development"));
		repository.add(new Department(601L,2L, "Operations"));
		repository.add(new Department(701L,2L, "HR"));
		repository.add(new Department(801L,2L, "Services"));
		repository.add(new Department(901L,2L, "Marketting"));		
		
		
		repository.add(new Department(501L,3L, "Development"));
		repository.add(new Department(601L,3L, "Operations"));
		repository.add(new Department(701L,3L, "HR"));
		repository.add(new Department(801L,3L, "Services"));
		repository.add(new Department(901L,3L, "Marketting"));		
		
		repository.add(new Department(501L,4L, "Development"));
		repository.add(new Department(601L,4L, "Operations"));
		repository.add(new Department(701L,4L, "HR"));
		repository.add(new Department(801L,4L, "Services"));
		repository.add(new Department(901L,4L, "Marketting"));		*/
		return repository;
	}

}

