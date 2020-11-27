package com.currency.exchange.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.exchange.service.beans.ExchangeValueBean;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValueBean, Long>{

	ExchangeValueBean findByFromAndTo(String from, String to);
}
