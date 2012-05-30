package com.pragiti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.dao.impl.CartDAOImpl;
import com.pragiti.domain.CreditCardDetails;
import com.pragiti.domain.Customer;
import com.pragiti.dao.impl.TransactionDAOImpl;
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
	public String transactionDetails(HttpSession session,
			@ModelAttribute("checkout") CreditCardDetails cardDetails,
			BindingResult result) {

		System.out.println("Name:" + cardDetails.getNameOnCard()
				+ "Card Number:" + cardDetails.getCreditcard_number()
				+ "CVV Number" + cardDetails.getCvv_number() + "expiry Year"
				+ cardDetails.getExpyear() + "expiry Month "
				+ cardDetails.getExpmonth());

		TransactionDAOImpl transDAOImpl = new TransactionDAOImpl();
		int customerId = Integer.parseInt(""
				+ session.getAttribute("customerId"));

		System.out.println("" + customerId);
		transDAOImpl.transactionDetails(cardDetails, customerId);
		return "redirect:thankYou.html";

	}

	@RequestMapping(value = "/thankYou", method = RequestMethod.GET)
	public ModelAndView showThankYou() {

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("thankYou");
	}

}
