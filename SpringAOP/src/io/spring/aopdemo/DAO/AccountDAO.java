package io.spring.aopdemo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.spring.aopdemo.entity.Account;

@Component("accountDAO")
public class AccountDAO {

	private int money;
	
	public List<Account> findAccounts() throws Exception
	{
		if(true)
		{
			throw new Exception("Throwing Exception");
		}
		List<Account> result= new ArrayList<>();
			result = new ArrayList<Account>();
		
			result.add(new Account("Akshay", 4));
			result.add(new Account("Akki", 5));
			TimeUnit.SECONDS.sleep(5);
			return result;
		
	}
	public void addAccount(String str)
	{
		System.out.println(getClass() + ":Doing MY DB work");
	}
	
	public void applyToDebitCard()
	{
		System.out.println(getClass() + ":Doing MY DB work for adding debit card");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}
