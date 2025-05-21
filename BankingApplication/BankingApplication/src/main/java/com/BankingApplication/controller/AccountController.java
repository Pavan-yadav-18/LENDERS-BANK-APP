package com.BankingApplication.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

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

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	// add account rest API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		System.out.println(accountDto);
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	//get account details
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		AccountDto accountdto = accountService.getAccountById(id);

		return ResponseEntity.ok(accountdto);
	}
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> depositeamount(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		Double amount = request.get("amount");
		AccountDto accountdto = accountService.deposit(id, amount);

		return ResponseEntity.ok(accountdto);
	}
	@PutMapping("/{id}/Withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		Double amount = request.get("amount");
		AccountDto accountdto = accountService.withdraw(id, amount);

		return ResponseEntity.ok(accountdto);
	}
	//@GetMapping("/msg") 
	public ResponseEntity<List<AccountDto>> getallaccounts() {      

		List<AccountDto> accountdto = accountService.getAllAccounts();

		return ResponseEntity.ok(accountdto);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id)
	{
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account succesfully deleted");
	}
	
	/*@GetMapping("/")
    public String homePage() {
        return "Hello Welcome to Home Page!!!  <a href = http://localhost:8081/api/accounts/msg > click here </a>  ";
    }*/

}
