package com.pragiti.dao;

import java.util.List;

import com.pragiti.domain.ProductItem;

public interface CartDAO {

	public List<ProductItem> showItems();

	public boolean addToCart(int customerId, int productId);

	public boolean removeFromCart(int customerId, int productId);
	
	public List<ProductItem> viewCart(int customerId);

}
