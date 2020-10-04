package com.moj.accounts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.moj.accounts.entity.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	AccountService accountService;

	@Before
	public void before() {
		accountService = new AccountService();
	}

	/**
	 * Tests the Retrieval of the account
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRetrievalOfAccounts() throws Exception {
		assertEquals(3, accountService.getAccounts().size());
	}

	/**
	 * Tests the Addition of the account
	 * 
	 * @throws Exception
	 */
	@Test
	public void testsAdditionOfAccounts() throws Exception {
		Account account = new Account(1, "first", "last", "1234");
		accountService.addAccount(account);
		assertEquals(4, accountService.getAccounts().size());
		assertEquals(true, accountService.getAccounts().contains(account));
	}

	/**
	 * Tests the Addition of the account
	 * 
	 * @throws Exception
	 */
	@Test
	public void testsDeletionOfAccount() throws Exception {
		String accountId = "1";
		accountService.deleteAccount(accountId);
		Optional<Account> accountDeleted = accountService.getAccounts().stream()
				.filter(t -> t.getId() == Integer.parseInt(accountId)).findAny();

		assertEquals(2, accountService.getAccounts().size());
		assertFalse(accountDeleted.isPresent());
	}

}
