package com.pragiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.dao.impl.CartDAOImpl;

@Controller
public class CartController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome() {

		System.out.println("home Page");

		CartDAOImpl cartDAOImpl = new CartDAOImpl();

		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("home", "items", cartDAOImpl.showItems());
	}
	
	public boolean addToCart()
	{
		
	}
	
	

}
