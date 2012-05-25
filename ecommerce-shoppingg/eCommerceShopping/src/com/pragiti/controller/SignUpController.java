package com.pragiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pragiti.dao.impl.CustomerDAOImpl;
import com.pragiti.domain.Customer;

@Controller
public class SignUpController {

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView showSignUp() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("login", "login", new Customer());
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String doSignUp(@ModelAttribute("user") Customer customer,
			BindingResult result) {

		System.out.println("First Name:" + customer.getFirstName()
				+ "Last Name:" + customer.getLastName());

		if(new CustomerDAOImpl().doSignUp(customer))
			return "redirect:home.html";
		else
			return "redirect:signUp.html";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome() {

		System.out.println("home apge");

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("home", "items", new Customer());
	}

}
