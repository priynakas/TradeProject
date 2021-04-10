package com.example.Trade.dataservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Trade.dto.TradeInfoDTO;

@Repository
public interface TradeStoreDAO {

	public void saveTradeInfo(TradeInfoDTO trade);

	public List<TradeInfoDTO> getTradeInfoList();

	public TradeInfoDTO getTradeInfoDTO(String tradeId);

}
