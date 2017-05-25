package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Brand;

public interface BrandService {

	void save(Brand brand);
	List<Brand> findAll();
	Brand findOne(int id);
	void delete(int id);
	Brand findByBrand(String name);
	Page<Brand> findAll(SimpleFilter filter, Pageable pageable);

}
