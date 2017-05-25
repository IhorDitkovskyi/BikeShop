package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;

public interface CategoryService {
	
	void save (Category category);

	List <Category> findAll();

	Category findOne(int id);
	
	Category findByCategory(String name);

	void delete(int id);
	
	Page<Category> findAll(SimpleFilter filter, Pageable pageable);

}
