package io.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.spring.aopdemo.DAO.AccountDAO;
import io.spring.aopdemo.DAO.InfoDAO;

public class AOPDemo {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO account = context.getBean("accountDAO",AccountDAO.class);
		
		InfoDAO info = context.getBean("infoDAO",InfoDAO.class);
		account.addAccount("Askk");
		//account.findAccounts();
		try
		{
			System.out.println(account.findAccounts());
		}
		catch(Exception e)
		{
			System.out.println("caught exception"+e.getMessage());
		}
		//account.applyToDebitCard();
		//account.setMoney(500);
		//System.out.println(account.getMoney());
		//info.addAccount();
		context.close();
	}
}
