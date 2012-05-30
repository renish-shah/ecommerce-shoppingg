package com.pragiti.test;

import static org.junit.Assert.*;
import com.pragiti.dao.impl.*;
import com.pragiti.domain.CreditCardDetails;

import org.junit.Test;

public class TransactionDAOImpltest {

	@Test
	public void testTransactionDetails() {
	//	fail("Not yet implemented");
		
		
		TransactionDAOImpl obj = new TransactionDAOImpl();
		CreditCardDetails details=new CreditCardDetails();
		details.setNameOnCard("Nirav");
		details.setCreditcard_number("12345");
		details.setExpyear("2012");
		details.setExpmonth("12");
		details.setCvv_number("123");
		
		
		assertEquals(true, obj.transactionDetails(details,5));
	}

}
