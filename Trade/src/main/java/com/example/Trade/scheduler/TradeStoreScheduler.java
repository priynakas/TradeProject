package com.example.Trade.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.Trade.service.TradeStoreService;

@Component
public class TradeStoreScheduler {

	@Autowired
	private TradeStoreService tradeStoreService;
	
	@Scheduled(cron = "0 15 10 15 * ?")
	public void scheduleTaskUsingCronExpression() {
		tradeStoreService.updateFlagOnCrossMatuityDate();
	}
}
