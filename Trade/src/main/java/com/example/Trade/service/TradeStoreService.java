package com.example.Trade.service;

import java.util.List;

import com.example.Trade.dto.TradeInfoDTO;
import com.example.Trade.exception.TradeStoreException;

public interface TradeStoreService {

	public void saveTradeInfo(TradeInfoDTO trade) throws TradeStoreException;

	public List<TradeInfoDTO> getTradeInfoList();

	public void updateFlagOnCrossMatuityDate();
}
