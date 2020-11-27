package com.limit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LimitServiceCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitServiceCloudConfigServerApplication.class, args);
	}

}
