package io.spring.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping("/loginPage")
	public String login()
	{
		return "fancy-login";
	}
	
	@RequestMapping("/access-denied")
	public String accessDeniedPage()
	{
		return "Access-denied";
	}
}
