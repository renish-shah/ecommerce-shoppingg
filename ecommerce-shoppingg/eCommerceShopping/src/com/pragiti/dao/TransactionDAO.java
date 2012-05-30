package com.pragiti.dao;

import com.pragiti.domain.CreditCardDetails;

public interface TransactionDAO {

	public boolean transactionDetails(CreditCardDetails cardDetails, int customerId);

}
