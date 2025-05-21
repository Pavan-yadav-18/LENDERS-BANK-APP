package com.BankingApplication.dto;

public class AccountDto {
	private Long id;

	private String accountholderName;

	private double balance;

	public AccountDto(Long id, String accountholderName, double balance) {
		super();
		this.id = id;
		this.accountholderName = accountholderName;
		this.balance = balance;
	}

	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountholderName() {
		return accountholderName;
	}

	public void setAccountholderName(String accountholderName) {
		this.accountholderName = accountholderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
