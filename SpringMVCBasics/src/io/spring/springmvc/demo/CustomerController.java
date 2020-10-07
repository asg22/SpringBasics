package io.spring.springmvc.demo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor str = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, str);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		model.addAttribute("customer",new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute Customer customer,BindingResult theBindingResults)
	{
		if(theBindingResults.hasErrors())
		{
			return "customer-form";
		}
		else
		{
			return "customer-confimation";
		}
	}
}
