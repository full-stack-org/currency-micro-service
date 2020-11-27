package com.currency.conversion.service.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.service.bean.CurrencyConversionBean;

@FeignClient(name = "netflix-zuul-api-gate-way")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean currencyConversion(@PathVariable("from") String from, @PathVariable("to") String to);
}
