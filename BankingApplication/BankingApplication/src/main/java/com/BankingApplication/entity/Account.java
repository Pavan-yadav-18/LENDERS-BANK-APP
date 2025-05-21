package com.BankingApplication.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name="Accountholder_Name")
	private String accountholderName;
		
	@Column(name="Balance")
	private double balance;

	// Constructor for account creation (no ID)
	public Account(String accountholderName, double balance) {
	    this.accountholderName = accountholderName;
	    this.balance = balance;
	}

	// Full constructor (used when mapping from DB to DTO)
	public Account(Long id, String accountholderName, double balance) {
	    this.id = id;
	    this.accountholderName = accountholderName;
	    this.balance = balance;
	}

		public Account() {
			super();
			
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
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


