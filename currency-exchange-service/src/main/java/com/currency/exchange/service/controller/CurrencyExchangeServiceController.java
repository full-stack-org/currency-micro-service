package com.currency.exchange.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.service.beans.ExchangeValueBean;
import com.currency.exchange.service.service.CurrencyExchangeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CurrencyExchangeServiceController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValueBean retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		ExchangeValueBean exchangeValueBean = currencyExchangeService.retriveExchangeValue(from, to);
		exchangeValueBean.setPort(port);
		log.info(" {} ",exchangeValueBean);
		return exchangeValueBean;

	}

}
