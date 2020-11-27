package com.limit.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limit.service.bean.LimitConfiguration;
import com.limit.service.config.PropertyConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private PropertyConfiguration propertyConfiguration;

	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "limtsFailed")
	public LimitConfiguration getLimitsFromConfiguration() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(propertyConfiguration.getMaximum(),
				propertyConfiguration.getMinimum());

		return limitConfiguration;

	}

	public LimitConfiguration limtsFailed() {
		return new LimitConfiguration(9999,9);
	}

}
