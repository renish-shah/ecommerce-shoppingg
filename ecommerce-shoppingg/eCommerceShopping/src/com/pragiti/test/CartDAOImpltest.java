package com.pragiti.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.pragiti.dao.impl.CartDAOImpl;

public class CartDAOImpltest {

	@Test
	public void testAddToCart() {
		// fail("Not yet implemented");
		CartDAOImpl obj = new CartDAOImpl();

		assertEquals(true, obj.addToCart(5, 2));
		assertNotNull(obj.addToCart(5, 2));
	}

	
	@Test
	public void testRemoveFromCart() {
		CartDAOImpl obj = new CartDAOImpl();
		assertEquals(true, obj.removeFromCart(5, 2));
		assertNotNull(obj.removeFromCart(5, 2));
		// fail("Not yet implemented");
	}

}
