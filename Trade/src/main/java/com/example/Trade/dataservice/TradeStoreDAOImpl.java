package com.example.Trade.dataservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.Trade.dto.TradeInfoDTO;

@Repository
public class TradeStoreDAOImpl implements TradeStoreDAO {
	public static Map<String, TradeInfoDTO> tradeMap = new ConcurrentHashMap<>();

	@Override
	public void saveTradeInfo(TradeInfoDTO trade) {
		tradeMap.put(trade.getTradeId(), trade);
	}

	@Override
	public List<TradeInfoDTO> getTradeInfoList() {
		List<TradeInfoDTO> resultList = new ArrayList<TradeInfoDTO>();
		resultList = tradeMap.values().stream().collect(Collectors.toList());
		return resultList;
	}
	
	@Override
	public TradeInfoDTO getTradeInfoDTO(String tradeId) {
		return tradeMap.values().stream().filter(trade-> tradeId.equals(trade.getTradeId())).findFirst().orElse(null);
	}

}
