package com.example.Trade.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.Trade.dataservice.TradeStoreDAO;
import com.example.Trade.dto.TradeInfoDTO;
import com.example.Trade.service.TradeStoreServiceImpl;

class TradeStoreServiceImplTest {
	
	@Mock
	private TradeStoreDAO tradeStoreDAO;
	
	@InjectMocks
	private TradeStoreServiceImpl tradeStoreServiceImpl;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void saveTradeInfoTest() {
		Date date = new Date();  
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		Mockito.when(tradeStoreDAO.getTradeInfoDTO("T1")).thenReturn(null);
		Mockito.doNothing().when(tradeStoreDAO).saveTradeInfo(trade);
		tradeStoreServiceImpl.saveTradeInfo(trade);
	}
	
	@Test
	void saveTradeInfoTest1() {
		Boolean notException=true;
		Date date = new Date();  
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		TradeInfoDTO trade1=new TradeInfoDTO("T1", 2, "CP-1", "B1",date, date, "N");
		Mockito.when(tradeStoreDAO.getTradeInfoDTO("T1")).thenReturn(trade1);
		Mockito.doNothing().when(tradeStoreDAO).saveTradeInfo(trade);
		try {
		tradeStoreServiceImpl.saveTradeInfo(trade);
		}catch(Exception e) {
			notException=false;
		}
		Assertions.assertFalse(notException);
	}
	
	@Test
	void saveTradeInfoTest2() {
		Boolean notException=true;
		Date date = new Date(0, 3, 1);
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		Mockito.when(tradeStoreDAO.getTradeInfoDTO("T1")).thenReturn(null);
		Mockito.doNothing().when(tradeStoreDAO).saveTradeInfo(trade);
		try {
		tradeStoreServiceImpl.saveTradeInfo(trade);
		}catch(Exception e) {
			notException=false;
		}
		Assertions.assertFalse(notException);
	}
	@Test
	void getTradeInfoListTest() {
		List<TradeInfoDTO> expected =new ArrayList<TradeInfoDTO>();
		Mockito.when(tradeStoreDAO.getTradeInfoList()).thenReturn(expected);
		List<TradeInfoDTO> result = tradeStoreServiceImpl.getTradeInfoList();
		Assertions.assertEquals(expected,result);
	}
	
	@Test
	void updateFlagOnCrossMatuityDateTest() {
		List<TradeInfoDTO> expected =new ArrayList<TradeInfoDTO>();
		Mockito.when(tradeStoreDAO.getTradeInfoList()).thenReturn(expected);
		tradeStoreServiceImpl.updateFlagOnCrossMatuityDate();
	}

}
