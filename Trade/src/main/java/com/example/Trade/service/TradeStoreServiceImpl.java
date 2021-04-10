package com.example.Trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trade.dataservice.TradeStoreDAO;
import com.example.Trade.dto.TradeInfoDTO;
import com.example.Trade.exception.TradeStoreException;
import com.example.Trade.utils.ApplicationConstant;
import com.example.Trade.utils.TradeStoreUtils;

@Service
public class TradeStoreServiceImpl implements TradeStoreService {
	@Autowired
	private TradeStoreDAO tradeStoreDAO;

	/**
	 * 
	 * @param trade
	 * @return
	 * @throws TradeStoreException
	 */
	public void saveTradeInfo(TradeInfoDTO trade) throws TradeStoreException {
		TradeInfoDTO oldtrade=tradeStoreDAO.getTradeInfoDTO(trade.getTradeId());
		if(oldtrade!=null) {
			if(oldtrade.getVersion()>trade.getVersion() ) {
				throw new TradeStoreException(ApplicationConstant.VERSION_ERROR);
			}else if(TradeStoreUtils.checkMaturityDate(trade.getMaturityDate())) {
				throw new TradeStoreException(ApplicationConstant.MATURITY_ERROR);
			} else {
				tradeStoreDAO.saveTradeInfo(trade);
			}
		}else if(TradeStoreUtils.checkMaturityDate(trade.getMaturityDate())) {
			throw new TradeStoreException(ApplicationConstant.MATURITY_ERROR);
		}else {
		tradeStoreDAO.saveTradeInfo(trade);
		}
	}


	/**
	 * 
	 * @return
	 */
	public List<TradeInfoDTO> getTradeInfoList() {
		return tradeStoreDAO.getTradeInfoList();
	}

	@Override
	public void updateFlagOnCrossMatuityDate() {
		List<TradeInfoDTO>  tradeInfoList =tradeStoreDAO.getTradeInfoList();
		tradeInfoList.stream().filter(e->TradeStoreUtils.checkMaturityDate(e.getMaturityDate())).forEach(trade->{
			trade.setExpired(ApplicationConstant.Y_VALUE);
			tradeStoreDAO.saveTradeInfo(trade);
		});
	}

	

}
