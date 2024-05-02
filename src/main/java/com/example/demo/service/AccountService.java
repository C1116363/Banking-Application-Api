package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account); 
	
	public Account getAccountDetailsByAccountNumber(Long number);
	
	public List<Account> getAllaccountDetails();
	
	public Account depositeMoney(Long number,Double amount);
	
	public Account withdrowMoney(Long number,Double amount);
	
	public void closeAccount(Long number);
	
		
	
	
	
	
	

}
