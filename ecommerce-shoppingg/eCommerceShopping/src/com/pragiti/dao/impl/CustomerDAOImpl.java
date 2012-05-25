/**
 * 
 */
package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pragiti.dao.CustomerDAO;
import com.pragiti.domain.Customer;

/**
 * @author renish
 * 
 */
public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void getContext(Customer customer) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring-datasource.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		// Customer customer = new Customer(1, "mkyong", 28);
		customerDAO.insertRecords(customer);// rt(customer);

		// Customer customer1 = customerDAO.findByCustomerId(1);
		// System.out.println(customer1);
	}

	@Override
	public void insertRecords(Customer customer) {

		String sql = "INSERT INTO CUSTOMER "
				+ "(firstname, lastname, email, password) VALUES ('"
				+ customer.getFirstName() + "','" + customer.getLastName()
				+ "','" + customer.getEmail() + "','" + customer.getPassword()
				+ "')";
		System.out.println("SQL :" + sql);

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, customer.getCustId());
			// ps.setString(2, customer.getName());
			// ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			System.out.println("Exception :"+e);

		} /*
		 * finally { if (conn != null) { try { conn.close(); } catch
		 * (SQLException e) { } } }
		 */
	}

}
