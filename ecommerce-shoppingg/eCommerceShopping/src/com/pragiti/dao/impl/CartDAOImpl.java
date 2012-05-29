/**
 * 
 */
package com.pragiti.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pragiti.dao.CartDAO;
import com.pragiti.dao.ConnectionDAO;
import com.pragiti.domain.ProductItem;

/**
 * @author renish
 * 
 */
public class CartDAOImpl implements CartDAO {

	@Override
	public List<ProductItem> showItems() {

		Connection conn = null;
		java.sql.Statement statement = null;

		String sql = "select * from product";

		System.out.println("sql is :" + sql);

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			List<ProductItem> itemList = new ArrayList<>();

			while (rs.next()) {

				ProductItem item = new ProductItem();
				item.setId(rs.getString("productId"));
				item.setDesc(rs.getString("product_desc"));
				item.setName(rs.getString("product_name"));
				item.setPrice(rs.getString("product_price"));
				item.setQuantity(rs.getString("product_quantity"));
				itemList.add(item);
			}
			return itemList;

		} catch (Exception e) {
			System.out.println("Exception in Checking SignIn:" + e);
			return null;
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
	public boolean addToCart(int customerId, int productId) {

		Connection conn = null;
		java.sql.Statement statement = null;

		// customerId = 5;

		String sql = "select product_quantity from cart where customerId='"
				+ customerId + "' and productId='" + productId + "'";

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("" + rs.getRow());
			if (rs.getRow() == 0) {
				rs = null;
				sql = "insert into cart(customerId, productId) values("
						+ customerId + "," + productId + ")";

			} else {

				rs.next();
				int productQuantity = rs.getInt(0);
				System.out.println("Product Q :" + productQuantity);

				sql = "insert into cart(customerId, productId, product_quantity) values('"
						+ customerId
						+ "','"
						+ productId
						+ "', '"
						+ (productQuantity + 1)
						+ "') where customerId='"
						+ customerId + "' and productId='" + productId + "'";
			}

			System.out.println("SQL :" + sql);
			statement = conn.createStatement();
			int rowCount = statement.executeUpdate(sql);

			System.out.println("Row Count :" + rowCount);
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

	@Override
	public boolean viewCart(int customerId, int productId) {
		// TODO Auto-generated method stub

		Connection conn = null;
		java.sql.Statement statement = null;

		String sql = "SELECT productId from cart where customerId='"
				+ customerId + "'";

		try {
			ConnectionDAO dao = new ConnectionDAOImpl().setupDataSource();
			conn = dao.getJdbcConnection();

			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				System.out.println("" + rs.getString(0));
			}

			while (rs.next()) {
				System.out.println("" + rs.getString(0));
			}

		} catch (Exception e) {
			// TODO: handle exception
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

		sql = "insert into cart(customerId, productQuantity) values() where customerId='"
				+ customerId + "' and productId='" + productId + "'";

		return false;
	}

	@Override
	public boolean removeFromCart(int customerId, int productId) {
		// TODO Auto-generated method stub

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

		sql = "DELETE FROM cart(customerId, productQuantity) values() where customerId='"
				+ customerId + "' and productId='" + productId + "'";

		return false;
	}

}
