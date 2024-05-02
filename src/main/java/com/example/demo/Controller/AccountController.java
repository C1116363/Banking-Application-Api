package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	
	@PostMapping("/createaccount")
	public Account createAccount(@RequestBody Account account) {
		
		Account createAccount=service.createAccount(account);
		return createAccount;
	}
	
	
	@GetMapping("{number}")
	public Account getAccountDetailsByAccountNumber(@PathVariable Long number) {
	Account account =	service.getAccountDetailsByAccountNumber(number);
		return account;
	}
	
	
	@GetMapping("/allaccount")
	public List<Account> getAllaccountDetails(){
	List<Account> all_account =service.getAllaccountDetails();
	
	return all_account;
	}
	
	@PutMapping("/deposite/{number}/{amount}")
	public Account depositeMoney(@PathVariable Long number,@PathVariable Double amount) {
	Account deposite_money =	service.depositeMoney(number, amount);
		return deposite_money;
	}
	
	@PutMapping("/withdrow/{number}/{amount}")
	public Account withdrowMoney(@PathVariable Long number,@PathVariable Double amount) {
	Account withdrow_money =	service.withdrowMoney(number, amount);
		return withdrow_money;
	} 
	
	@DeleteMapping("/delete/{number}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long number) {
		
	service.closeAccount(number);
		
	return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account Closed");
		
		
	}

}
