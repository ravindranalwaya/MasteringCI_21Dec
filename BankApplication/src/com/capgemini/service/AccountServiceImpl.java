package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmountException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialBalanceException
	{
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
		
	}
	
	@Override
	public boolean deposit(int accountNumber,int amount) throws InvalidAmountException, InvalidAccountNumberException {
		
		if(accountNumber < 0) {
			throw new InvalidAmountException();
		}
		
		if(amount < 0) {
			throw new InvalidAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return true;
		}
		
	
		
		return false;
	}
	@Override
	public int withdraw(Account account,int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		
		if(account.getAccountNumber() != accountNumber) {
			throw new InvalidAccountNumberException();
		}
		if(amount > account.getAmount()) {
			throw new InsufficientBalanceException();
		}
		return 0;
	}
	@Override
	public boolean FundTranfer(Account account1,Account account2) {
		// TODO Auto-generated method stub
		return false;
	}

}
