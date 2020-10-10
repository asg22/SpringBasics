package io.spring.aopdemo.DAO;

import org.springframework.stereotype.Component;

@Component("infoDAO")
public class InfoDAO {

	
	public String addAccount()
	{
		System.out.println(getClass() + ":Doing MY DB work");
		return null;
	}
	
}
