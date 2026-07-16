package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
public class AccountController {

	// Dummy response - no backend connectivity as per the exercise
	@GetMapping("/accounts/{number}")
	public Account getAccountDetails(@PathVariable String number) {
		return new Account(number, "savings", 234343);
	}

}
