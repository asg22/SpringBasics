package io.spring.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAppController {

	@RequestMapping("/")
	public String showHome()
	{
		return "index";
	}
}
