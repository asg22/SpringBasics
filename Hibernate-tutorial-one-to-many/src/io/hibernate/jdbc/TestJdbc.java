package io.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	
	public static void main(String[] args) {
		
		
		String jdbcURI="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String usr="root";
		String pwd="Redmi5@2212";
		try
		{
			System.out.println("connecting to DB:"+jdbcURI);
			Connection mycon = DriverManager.getConnection(jdbcURI,usr,pwd);
			
			System.out.println("connection sccessful");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
