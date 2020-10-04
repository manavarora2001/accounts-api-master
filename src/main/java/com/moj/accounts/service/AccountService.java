package com.moj.accounts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.moj.accounts.entity.Account;

@Service
public class AccountService {

	/**
	 * List of accounts hard-coded here as not being stored in database
	 */
	List<Account> accounts = new ArrayList<Account>(Arrays.asList(new Account(1, "John", "Doe", "1234"),
			new Account(2, "Jane", "Don", "1235"), new Account(3, "Jim", "Taylor", "1236")));

	/**
	 * Get all the accounts
	 * 
	 * @return
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * Adds the account
	 * 
	 * @param account
	 * @return
	 */
	public String addAccount(Account account) {
		String message = "Account has been added successfully";
		try {
			accounts.add(account);
		} catch (Exception e) {
			message = "Unsuccessfull to add the account ";
		}
		return message;
	}

	/**
	 * Deletes the account of the passed id
	 * 
	 * @param id
	 * @return
	 */
	public String deleteAccount(String id) {
		String message = "Account has been deleted successfully";
		try {
			
			accounts.removeIf(t -> t.getId() == Integer.parseInt(id));
		} catch (Exception e) {
			message = "Unsuccessfull to delete the account ";
		}
		return message;
	}

}
