package com.BankingApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.Account;
import com.BankingApplication.mapper.AccountMapper;
import com.BankingApplication.repository.AccountRepository;
import com.BankingApplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.maptoAccount(accountDto);

		Account savedaccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedaccount);
	}



	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not excists"));
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not excists"));

		double totalbalance = account.getBalance() + amount;

		account.setBalance(totalbalance);

		Account saveaccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveaccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not excists"));

		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance !!");
		}

		double totalbalance = account.getBalance() - amount;

		account.setBalance(totalbalance);

		Account saveaccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(saveaccount);
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepository.findAll().stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
	}



	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not excists"));
		
		accountRepository.delete(account);
		
	}
	

	
}
