package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmountException;
import com.capgemini.model.Account;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException;

	public boolean deposit(int accountNumber,int amount) throws InvalidAmountException,InvalidAccountNumberException;
	public int withdraw(Account account,int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientBalanceException;
	public boolean FundTranfer(Account account1, Account account2); 
}