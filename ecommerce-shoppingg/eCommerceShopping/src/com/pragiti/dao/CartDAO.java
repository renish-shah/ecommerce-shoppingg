package com.pragiti.dao;

public interface CartDAO {

	public boolean showItems();

	public boolean addToCart(int customerId, int productId);

	public boolean removeFromCart(int customerId, int productId);

	public boolean viewCart();

}
