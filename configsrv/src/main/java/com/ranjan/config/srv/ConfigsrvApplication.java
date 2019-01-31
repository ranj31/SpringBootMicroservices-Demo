package com.ranjan.config.srv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigsrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigsrvApplication.class, args);
	}

}

