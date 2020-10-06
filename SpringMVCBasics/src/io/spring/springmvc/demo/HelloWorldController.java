package io.spring.springmvc.demo;

import javax.servlet.http.HttpServletRequest;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	
	@RequestMapping("/dispForm")
	public String showForm()
	{
		return "helloWorld-Form";
	}
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloWorld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model)
	{
		String name = request.getParameter("name");
		
		name="YO!! "+ name.toUpperCase();
		
		model.addAttribute("message",name);
		
		return "helloWorld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam String name, Model model)
	{
		
		name="YO!!!! "+ name.toUpperCase();
		
		model.addAttribute("message",name);
		
		return "helloWorld";
	}
}
