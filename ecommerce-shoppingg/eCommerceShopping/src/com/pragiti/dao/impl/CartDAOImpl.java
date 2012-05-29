/**
 * 
 */
package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pragiti.dao.CartDAO;
import com.pragiti.dao.ConnectionDAO;
import com.pragiti.domain.ProductItem;

/**
 * @author renish
 * 
 */
public class CartDAOImpl implements CartDAO {

	@Override
	public boolean showItems() {

		Connection conn = null;
		java.sql.Statement statement = null;

		String sql = "select * from product";

		System.out.println("sql is :" + sql);

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				ProductItem item = new ProductItem();
				item.setId(rs.getString("productId"));
				item.setDesc(rs.getString("product_desc"));
				item.setName(rs.getString("product_name"));
				item.setPrice(rs.getString("product_price"));
				item.setQuantity(rs.getString("product_quantity"));

			}
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
		return false;
	}

	@Override
	public boolean addToCart(int customerId, int productId) {

		Connection conn = null;
		java.sql.Statement statement = null;

		customerId = 5;

		String sql = "select product_quantity from cart where customerId='"
				+ customerId + "'";

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				System.out.println("" + rs.getString(0));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		sql = "insert into cart(customerId, productQuantity) values() where customerId='"
				+ customerId + "' and productId='" + productId + "'";

		return false;
	}

	@Override
	public boolean viewCart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFromCart(int customerId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

}
