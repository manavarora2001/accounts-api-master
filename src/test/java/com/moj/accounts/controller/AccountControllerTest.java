package com.moj.accounts.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.moj.accounts.entity.Account;
import com.moj.accounts.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	/**
	 * Tests the retrieve of account with url
	 * 
	 * @throws Exception
	 */
	@Test
	public void testController_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/accounts").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andReturn();

	}

	/**
	 * Tests the Retrieval of the accounts with data
	 * 
	 * @throws Exception
	 */
	@Test
	public void testControllerGetAccounts() throws Exception {
		when(accountService.getAccounts()).thenReturn(Arrays.asList(new Account(1, "Manav", "Arora", "1234")));

		RequestBuilder request = MockMvcRequestBuilders.get("/accounts").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{id:1,firstName:Manav,lastName:Arora,accountNumber:'1234'}]")).andReturn();

	}

	/**
	 * Tests the addition of the account
	 * 
	 * @throws Exception
	 */
	@Test
	public void testControllerAddAccount() throws Exception {
		when(accountService.addAccount(Mockito.any(Account.class))).thenReturn("Account added successfully");

		String account = " {\n" + "        \"id\": 1,\n" + "        \"firstName\": \"John\",\n"
				+ "        \"lastName\": \"Doe\",\n" + "        \"accountNumber\": \"1234\"\n" + "    }";

		mockMvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON).content(account))
				.andExpect(status().isOk()).andExpect(content().string("Account added successfully"));
	}

	/**
	 * Tests the deletion of the account
	 * 
	 * @throws Exception
	 */
	@Test
	public void testControllerDeleteAccount() throws Exception {
		when(accountService.deleteAccount(Mockito.any(String.class))).thenReturn("Account deleted successfully");
		String accountId = "1";
		mockMvc.perform(delete("/accounts/" + accountId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string("Account deleted successfully"));
	}
}
