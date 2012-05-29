package com.pragiti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pragiti.domain.Customer;

@Controller
public class SignInController {

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView showSignIn() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("SignIn", "SignIn", new Customer());
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String doSignIn(@ModelAttribute("email") Customer user,
			BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return null;
		}

		System.out.println("Email:" + user.getEmail() + "Password:"
				+ user.getPassword());
		
		session.setAttribute("customerId", user.get)

		return "redirect:home.html";
	}

}
