package com.renji.bank.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.renji.bank.entity.Transaction;

@RestController
@RequestMapping("/api/v1/bank")
public class PaymentController {

	@Autowired
	RestTemplate restTemplate;

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

	@RequestMapping(value = "transferAmount", method = RequestMethod.POST)
	public ResponseEntity<String> transferAmount(@RequestBody Transaction transaction) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Transaction> request = new HttpEntity<>(transaction, headers);
		ResponseEntity<Transaction> responseEntity = restTemplate.postForEntity("http://localhost:8081/api/v1/transfer", request, Transaction.class);
		
		String response = responseEntity.getBody().getStatus();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "balanceCheck ", method = RequestMethod.GET)
	public ResponseEntity<String> balanceCheck() {
		return new ResponseEntity<>("balanceCheck", HttpStatus.OK);
	}

}
