package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
