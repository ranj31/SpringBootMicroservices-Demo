package com.ranjan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ranjan.demo.model.Organization;
import com.ranjan.demo.repository.OrganizationRepository;

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
public class OrganizationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ranjan.demo.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Organization API").description("Documentation Organization API v1.0").build());
	}
	
	@Bean
	OrganizationRepository repository() {
		OrganizationRepository repository = new OrganizationRepository();
		repository.add(new Organization(1L,"Tech Mahindra", "Pune, India"));
		repository.add(new Organization(2L,"Oracle", "Redwood City, California, USA"));
		repository.add(new Organization(3L,"Reliance", "navi Mumbai City, Mumbai, India"));
		repository.add(new Organization(4L,"AtoS", "Paris, France"));
		return repository;
	}
}

