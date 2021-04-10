package com.example.Trade.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Trade.dto.TradeInfoDTO;
import com.example.Trade.service.TradeStoreService;


class TradeControllerTest {

	@InjectMocks
	private TradeContoller tradeContoller;
	
	@Mock
	private TradeStoreService tradeStoreService;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void saveTradeInfoTest() {
		Date date = new Date();  
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		Mockito.doNothing().when(tradeStoreService).saveTradeInfo(trade);
		ResponseEntity<String> responseEntity = tradeContoller.saveTradeInfo(trade);
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),responseEntity);
	}
	@Test
	void getTradeInfoListTest() {
		List<TradeInfoDTO> expected =new ArrayList<TradeInfoDTO>();
		List<TradeInfoDTO> result = tradeContoller.getTradeInfoList();
		Mockito.when(tradeStoreService.getTradeInfoList()).thenReturn(expected);
		Assertions.assertEquals(expected,result);
	}
}
