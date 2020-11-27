package com.currency.exchange.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.exchange.service.beans.ExchangeValueBean;
import com.currency.exchange.service.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public ExchangeValueBean retriveExchangeValue(String from,String to) {
		
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}
}
