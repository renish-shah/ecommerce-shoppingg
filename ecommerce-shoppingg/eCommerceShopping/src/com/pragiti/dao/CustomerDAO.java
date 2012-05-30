package com.pragiti.dao;

import com.pragiti.domain.Customer;

public interface CustomerDAO {

	public int checkSignIn(Customer customer);
	public int doSignUp(Customer customer);
	
	
}
