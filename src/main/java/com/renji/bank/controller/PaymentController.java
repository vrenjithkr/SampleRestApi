package com.renji.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class PaymentController {

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public ResponseEntity<String> createUser() {
		return new ResponseEntity<>("New user is created", HttpStatus.OK);
	}
	
	@RequestMapping(value = "depositAmount ", method = RequestMethod.PUT)
	public ResponseEntity<String> depositAmount() {
		return new ResponseEntity<>("Amount is deposited", HttpStatus.OK);
	}
	
	@RequestMapping(value = "addReceiverAccount", method = RequestMethod.POST)
	public ResponseEntity<String> addReceiverAccount() {
		return new ResponseEntity<>("Added receiver account", HttpStatus.OK);
	}
	
	@RequestMapping(value = "transferAmount  ", method = RequestMethod.POST)
	public ResponseEntity<String> transferAmount () {
		return new ResponseEntity<>("Amount transfered", HttpStatus.OK);
	}
	
	@RequestMapping(value = "balanceCheck ", method = RequestMethod.GET)
	public ResponseEntity<String> balanceCheck () {
		return new ResponseEntity<>("", HttpStatus.OK);
	}


}
