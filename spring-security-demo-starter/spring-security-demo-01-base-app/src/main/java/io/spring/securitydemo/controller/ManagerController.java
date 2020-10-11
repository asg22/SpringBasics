package io.spring.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {

	@RequestMapping("/leaders")
	public String showManagersPage()
	{
		return "leaders";
	}
}
