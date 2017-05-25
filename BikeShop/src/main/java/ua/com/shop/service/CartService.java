package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Cart;

public interface CartService {

	void save(Cart cart);
	
	Cart findOne(int id);
	
	List<Cart> findAll();
	
	void delete(int id);
}
