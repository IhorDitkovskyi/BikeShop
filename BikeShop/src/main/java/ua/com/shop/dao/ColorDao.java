package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer>, JpaSpecificationExecutor<Color>{

	Color findByColor(String name);

	
}
