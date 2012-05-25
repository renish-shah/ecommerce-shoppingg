/**
 * 
 */
package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pragiti.dao.ConnectionDAO;
import com.pragiti.dao.CustomerDAO;
import com.pragiti.domain.Customer;

/**
 * @author renish
 * 
 */
public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;
	static CustomerDAO customerDAO;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * public CustomerDAO getContext() { ApplicationContext context = new
	 * ClassPathXmlApplicationContext( "/spring-datasource.xml");
	 * 
	 * DataSource dataSource = (DataSource) context.getBean("dataSource");
	 * Connection connection = dataSource.getConnection();
	 * 
	 * return customerDAO = (CustomerDAO) context.getBean("customerDAO");
	 * 
	 * // customerDAO.insertRecords(customer);// rt(customer);
	 * 
	 * // Customer customer1 = customerDAO.findByCustomerId(1); //
	 * System.out.println(customer1); }
	 */
	public boolean checkSignIn(Customer customer) {
		Connection conn = null;
		java.sql.Statement statement = null;

		String sql = "select * from customer where email = '"
				+ customer.getEmail() + "' and password = '"
				+ customer.getPassword() + "'";

		System.out.println("sql is :" + sql);

		try {

			conn = dataSource.getConnection();
			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Exception in Checking SignIn:" + e);
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

	@Override
	public boolean doSignUp(Customer customer) {

		Connection conn = null;
		java.sql.Statement statement = null;

		String sql = "select * from customer where email = '"
				+ customer.getEmail() + "'";

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				return false;
			}

			sql = "INSERT INTO CUSTOMER "
					+ "(firstname, lastname, email, password) VALUES ('"
					+ customer.getFirstName() + "','" + customer.getLastName()
					+ "','" + customer.getEmail() + "','"
					+ customer.getPassword() + "')";

			System.out.println("SQL :" + sql);

			statement.executeUpdate(sql);
			return true;

		} catch (SQLException e) {
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
