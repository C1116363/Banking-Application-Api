package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositary.AccountRepositary;
import com.example.demo.entity.Account;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepositary repo;

	@Override
	public Account createAccount(Account account) {
	Account account_saved_Account = repo.save(account);
		return account_saved_Account;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long number) {
		
	Optional<Account> account =	repo.findById(number);
	if (account.isEmpty()) {
		throw new  RuntimeException ("Account not found");
		
	}
	Account account_found =account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllaccountDetails() {
	List<Account> getall = 	repo.findAll();
		return getall;
	}

	@Override
	public Account depositeMoney(Long number, Double amount) {
	Optional<Account> account=	repo.findById(number);
	if (account.isEmpty()) {
		throw new RuntimeException("account not found");	
	}
	Account account_found=account.get();
	
    Double totalbalance =	account_found.getBalance()+amount;
    
    account_found.setBalance(totalbalance);
    repo.save(account_found);
	
	
	
		return account_found;
	}

	@Override
	public Account withdrowMoney(Long number, Double amount) {
		Optional<Account> account=	repo.findById(number);
		if (account.isEmpty()) {
			throw new RuntimeException("account not found");	
		}
		Account account_found=account.get();
		
	    Double totalbalance =	account_found.getBalance()-amount;
	    
	    account_found.setBalance(totalbalance);
	    repo.save(account_found);
		
			return account_found;
		
	}

	@Override
	public void closeAccount(Long number) {
		getAccountDetailsByAccountNumber(number);
		repo.deleteById(number);;
		
	}

}
