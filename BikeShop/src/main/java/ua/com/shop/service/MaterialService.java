package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Material;


public interface MaterialService {

	void save(Material material);

	List<Material> findAll();

	Material findOne(int id);

	void delete(int id);

	Material findByMaterial(String material);
	
}
