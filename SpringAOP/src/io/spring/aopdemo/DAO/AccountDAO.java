package io.spring.aopdemo.DAO;

import org.springframework.stereotype.Component;

@Component("accountDAO")
public class AccountDAO {

	private int money;
	
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
