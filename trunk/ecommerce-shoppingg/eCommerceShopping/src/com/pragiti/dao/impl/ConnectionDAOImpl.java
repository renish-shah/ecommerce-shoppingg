package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pragiti.dao.ConnectionDAO;

public class ConnectionDAOImpl implements ConnectionDAO {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ConnectionDAO setupDataSource() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring-datasource.xml");

		ConnectionDAO connDao = (ConnectionDAO) context
				.getBean("connectionDAO");
		
		return connDao;
	}

	public Connection getJdbcConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
