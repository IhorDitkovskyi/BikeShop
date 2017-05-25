package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {

	Brand findByBrand(String name);

}
