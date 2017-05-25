package ua.com.shop.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Commodity;


public interface CommodityDao extends JpaRepository <Commodity, Integer>, JpaSpecificationExecutor<Commodity> {

	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.brand LEFT JOIN FETCH c.category "
			+ "LEFT JOIN FETCH c.color LEFT JOIN FETCH c.material")
	List<Commodity> findAll();
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.brand LEFT JOIN FETCH c.category "
			+ "LEFT JOIN FETCH c.color LEFT JOIN FETCH c.material WHERE c.id=?1")
	Commodity findOne(int id);
	
	@Query("SELECT c FROM Commodity c WHERE c.brand.id=?1 and c.category.id=?2 and c.color.id=?3 "
			+ "and c.material.id=?4 and c.price=?5")
	Commodity findUnique(int brandId, int categoryId, int colorId,
			int materialId, double price);
	
	@Query(value="SELECT c FROM Commodity c LEFT JOIN FETCH c.brand LEFT JOIN FETCH c.category "
			+ "LEFT JOIN FETCH c.color LEFT JOIN FETCH c.material", 
			countQuery="SELECT count(c.id) FROM Commodity c")
	Page<Commodity> findAll(Pageable pageable);

}
