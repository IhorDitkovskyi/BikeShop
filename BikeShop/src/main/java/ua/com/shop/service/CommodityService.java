package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Material;


public interface CommodityService {

void save(CommodityForm  commodity);
	
	List<Commodity> findAll();
	
	Commodity findOne(int id);
	
	CommodityForm findForm(int id);
	
	void delete(int id);
	
	Commodity findUnique(Brand brand, Category category, Color color,
			Material material, String price);
	
	Page<Commodity> findAll(Pageable pageable, CommodityFilter filter);
}
