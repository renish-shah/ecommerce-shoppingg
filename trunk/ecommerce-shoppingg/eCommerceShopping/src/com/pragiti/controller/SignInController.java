package com.pragiti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.dao.impl.CustomerDAOImpl;
import com.pragiti.domain.Customer;

@Controller
public class SignInController {

	private static final String REDIRECT_HOME_HTML = "redirect:home.html";
	private static final String REDIRECT_SIGN_IN_HTML = "redirect:signIn.html";

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView showSignIn() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("SignIn", "SignIn", new Customer());
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String doSignIn(@ModelAttribute("email") Customer customer,
			BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return null;
		}

		System.out.println("Email:" + customer.getEmail() + "Password:"
				+ customer.getPassword());

		int customerId = 0;
		customerId = new CustomerDAOImpl().checkSignIn(customer);
		if (customerId != 0) {
			session.setAttribute("customerId", customerId);
			
			System.out.println(""+session.getAttribute("customerId"));
			
			return REDIRECT_HOME_HTML;
		}
		else
			return REDIRECT_SIGN_IN_HTML;

	}

}
