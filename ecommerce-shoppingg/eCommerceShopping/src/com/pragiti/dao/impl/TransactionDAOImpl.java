package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pragiti.dao.TransactionDAO;
import com.pragiti.dao.ConnectionDAO;
import com.pragiti.domain.CreditCardDetails;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean transactionDetails(CreditCardDetails cardDetails,
			int customerId) {
		Connection conn = null;
		java.sql.Statement statement = null;
try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
		
			String sql = "insert into transaction(customerId, nameOnCard, creditcard_number, expyear, expmonth, cvv_number) values("
						+ customerId
						+ ",'"+ cardDetails.getNameOnCard()+ "','"
						+ cardDetails.getCreditcard_number()
						+ "','"
						+ cardDetails.getExpyear()
						+ "','"
						+ cardDetails.getExpmonth()
						+ "','"
						+ cardDetails.getCvv_number() + "')";

			
			System.out.println("SQL :" + sql);
			int rs = statement.executeUpdate(sql);

	//		System.out.println("Row Count :" + rowCount);
			return true;

		} catch (Exception e) {
			System.out.println("Exception :" + e);
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out
							.println("SQL Exception while closing connection:"
									+ e);

				}
			}
		}

	}

}
