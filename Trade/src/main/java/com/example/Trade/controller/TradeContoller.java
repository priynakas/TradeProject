package com.example.Trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trade.dto.TradeInfoDTO;
import com.example.Trade.service.TradeStoreService;

@RestController
public class TradeContoller {

	@Autowired
	private TradeStoreService tradeStoreService;

	@PostMapping(value = "/saveTrade", consumes = "application/json")
	public ResponseEntity<String> saveTradeInfo(@RequestBody TradeInfoDTO trade) {
		
		tradeStoreService.saveTradeInfo(trade);
		
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@GetMapping(value = "/getTradeList")
	public List<TradeInfoDTO> getTradeInfoList() {
		return tradeStoreService.getTradeInfoList();

	}
}
