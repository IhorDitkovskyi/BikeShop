package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CartDao;
import ua.com.shop.entity.Cart;
import ua.com.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;

	@Override
	public void save(Cart cart) {
		cartDao.save(cart);		
	}

	@Override
	public Cart findOne(int id) {
		return cartDao.findOne(id);
	}

	@Override
	public List<Cart> findAll() {
		return cartDao.findAll();
	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);		
	}
	
	
}
