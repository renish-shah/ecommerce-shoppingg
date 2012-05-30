package com.pragiti.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.pragiti.dao.impl.*;
import com.pragiti.domain.Customer;

public class CustomerDAOImpltest {

	@Test
	public void testCheckSignIn() {

		CustomerDAOImpl object = new CustomerDAOImpl();

		Customer customer = new Customer();
		customer.setEmail("nirav@pragiti.com");
		customer.setPassword("nirav");

		assertEquals(1, object.checkSignIn(customer));
		// fail("Not yet implemented");
	}

	@Test
	public void testDoSignUp() {
		// fail("Not yet implemented");
		CustomerDAOImpl object = new CustomerDAOImpl();

		Customer customer = new Customer();
		customer.setEmail("nirav@pragiti.com");
		customer.setPassword("nirav");
		customer.setFirstName("Nirav");
		customer.setLastName("Makwana");

		assertEquals(1, object.checkSignIn(customer));

	}

}
