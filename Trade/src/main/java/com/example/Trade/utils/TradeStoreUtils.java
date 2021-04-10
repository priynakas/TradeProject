package com.example.Trade.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TradeStoreUtils {

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static boolean checkMaturityDate(Date date) {
		LocalDate localDate = date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
		LocalDate currentDate = LocalDate.now();
		return currentDate.isAfter(localDate);
	}
}
