package com.pragiti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.pragiti.dao.impl.CartDAOImpl;

@Controller
public class CartController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHome(HttpServletRequest request) {

		HashMap map = new HashMap();
		if (null != request.getParameter("addToCart")) {
			if (request.getParameter("addToCart").equalsIgnoreCase("success"))
			{
				map.put("addToCart", "success");
			}
		}
		System.out.println("home Page");

		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		map.put("items", cartDAOImpl.showItems());
		// ModelAndView (JSP Page, Command Name, Domain Object)
		return new ModelAndView("home", "allItems", map);
	}

	@RequestMapping(value = "/addToCart")
	public String addToCart(HttpServletRequest request, HttpSession session) {

		String itemId = "";
		itemId = request.getParameter("itemId");
		System.out.println("" + itemId);

		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		int customerId = Integer.parseInt(""
				+ session.getAttribute("customerId"));

		System.out.println("" + customerId);

		cartDAOImpl.addToCart(customerId, Integer.parseInt(itemId));

		return "redirect:home.html?addToCart=success";
	}

	@RequestMapping(value = "/removeFromCart")
	public String removeFromCart(HttpServletRequest request, HttpSession session) {

		String itemId = "";
		itemId = request.getParameter("itemId");
		System.out.println("" + itemId);
		
		CartDAOImpl cartDAOImpl=new CartDAOImpl();
		int customerId=Integer.parseInt(""+session.getAttribute("customerId"));
		
		System.out.println(""+customerId);
		
		cartDAOImpl.removeFromCart(customerId, Integer.parseInt(itemId));
		
		return "redirect:home.html";
	}

}
