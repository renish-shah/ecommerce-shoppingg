package com.pragiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.domain.User;

@Controller
public class SignUpController {

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView showSignUp() {

		// ModelAndView (JSP Page, Command Name, Domain Object) 
		return new ModelAndView("login", "login", new User());
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String doSignUp(@ModelAttribute("user") User user,
			BindingResult result) {

		System.out.println("First Name:" + user.getFirstName() + "Last Name:"
				+ user.getLastName());

		return "redirect:contacts.html";
	}

}
