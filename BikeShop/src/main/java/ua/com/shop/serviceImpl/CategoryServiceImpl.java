package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(Category  category) {
		categoryDao.save(category);		
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);		
	}

	public Category findByCategory(String name) {
		return categoryDao.findByCategory(name);
	}

	@Override
	public Page<Category> findAll(SimpleFilter filter, Pageable pageable) {
		return categoryDao.findAll(findByNameLike(filter), pageable);
	}
	
	private Specification<Category> findByNameLike(SimpleFilter filter){
		return (root, query, cb)-> {
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("category")), filter.getSearch().toLowerCase()+"%");
		};
	}




}
