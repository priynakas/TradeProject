package com.example.Trade.dataservice;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.Trade.dto.TradeInfoDTO;

public class TradeStoreDAOImplTest {
	
	
	Date date = new Date();  

	@Test
	void saveTradeInfoTest() {
		TradeStoreDAOImpl tradeStoreDAOImpl=new TradeStoreDAOImpl();
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		tradeStoreDAOImpl.saveTradeInfo(trade);
	}
	@Test
	void getTradeInfoListTest() {
		TradeStoreDAOImpl tradeStoreDAOImpl=new TradeStoreDAOImpl();
		TradeInfoDTO trade=new TradeInfoDTO("T1", 1, "CP-1", "B1",date, date, "N");
		tradeStoreDAOImpl.saveTradeInfo(trade);
		List<TradeInfoDTO> result = tradeStoreDAOImpl.getTradeInfoList();
		Assertions.assertEquals(result.get(0).getTradeId(),"T1");
	}

	@Test
	void getTradeInfoTest() {
		TradeStoreDAOImpl tradeStoreDAOImpl=new TradeStoreDAOImpl();
		TradeInfoDTO trade=new TradeInfoDTO("T2", 1, "CP-1", "B2",date, date, "N");
		tradeStoreDAOImpl.saveTradeInfo(trade);
		TradeInfoDTO result = tradeStoreDAOImpl.getTradeInfoDTO("T2");
		Assertions.assertEquals(result.getBookId(),"B2");
	}
}
