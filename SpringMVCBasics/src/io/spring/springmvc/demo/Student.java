package io.spring.springmvc.demo;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;

public class Student {

	
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favLang;
	private String[] opSys;
	public Student()
	{
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("France", "France");
		countryOptions.put("Brazil", "Brazil");
		countryOptions.put("USA", "USA");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	public String getFavLang() {
		return favLang;
	}
	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}
	public String[] getOpSys() {
		return opSys;
	}
	public void setOpSys(String[] opSys) {
		this.opSys = opSys;
	}

	
	
}
