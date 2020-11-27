package com.currency.conversion.service.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversion.service.bean.CurrencyConversionBean;
import com.currency.conversion.service.proxy.CurrencyExchangeServiceProxy;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseConversionBean = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean currencyConversionBean = responseConversionBean.getBody();
		log.info(" {} ",currencyConversionBean);
		return new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(),
				currencyConversionBean.getTo(), currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean currencyConversionBean = proxy.currencyConversion(from, to);

		log.info(" {} ",currencyConversionBean);
		
		return new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(),
				currencyConversionBean.getTo(), currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
	}
}
