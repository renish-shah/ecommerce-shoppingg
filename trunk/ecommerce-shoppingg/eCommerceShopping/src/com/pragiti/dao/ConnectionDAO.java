package com.pragiti.dao;

import java.sql.Connection;

public interface ConnectionDAO {

	public ConnectionDAO setupDataSource();
	public Connection getJdbcConnection();
}
