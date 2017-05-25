package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart>{

}
