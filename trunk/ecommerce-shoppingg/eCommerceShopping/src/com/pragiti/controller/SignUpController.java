package com.pragiti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.pragiti.dao.impl.CustomerDAOImpl;
import com.pragiti.domain.Customer;

@Controller
@SessionAttributes
public class SignUpController {

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView showSignUp() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("login", "login", new Customer());
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String doSignUp(@ModelAttribute("user") Customer customer,
			BindingResult result, HttpSession session) {

		System.out.println("First Name:" + customer.getFirstName()
				+ "Last Name:" + customer.getLastName());

		int customerId=new CustomerDAOImpl().doSignUp(customer);
		
		if(customerId!=0)
		{
			
			session.setAttribute("customerId", customerId);
			System.out.println("CustomerId :"+session.getAttribute("customerId"));
			return "redirect:home.html";
		}
		else
			return "redirect:signUp.html";
	}

}
