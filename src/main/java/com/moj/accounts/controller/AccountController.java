package com.moj.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moj.accounts.entity.Account;
import com.moj.accounts.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAccounts();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts")
	public String addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
	public String deleteAccount(@PathVariable String id) {
		return accountService.deleteAccount(id);
	}


}
