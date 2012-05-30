package com.pragiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.domain.CreditCardDetails;

//import com.pragiti.dao.impl.CustomerDAOImpl;
//import com.pragiti.domain.Customer;

@Controller
public class CheckoutController {

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView showCheckout() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("Checkout", "checkout", new CreditCardDetails());
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String doCheckout(@ModelAttribute("checkout") CreditCardDetails creditcarddetails,
			BindingResult result) {

		System.out.println("Name:" + creditcarddetails.getNameOnCard() + "Card Number:" + creditcarddetails.getCreditcard_number() + "CVV Number" + creditcarddetails.getCvv_number() + "expiry Year" + creditcarddetails.getExpyear() + "expiry Month " + creditcarddetails.getExpmonth());

		return "redirect:thankYou.html";
	}
	@RequestMapping(value = "/thankYou", method = RequestMethod.GET)
	public ModelAndView showThankYou() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("thankYou");
	}

	
	
}
