package com.example.Trade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Trade.exception.TradeStoreException;

@ControllerAdvice
public class TradeContollerAdvice {

	@ExceptionHandler(value = TradeStoreException.class)
	   public ResponseEntity<Object> exception(TradeStoreException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	   }	
}
