package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CommodityDao;
import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Commodity;
import ua.com.shop.entity.Material;
import ua.com.shop.service.CommodityService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.specification.CommoditySpecification;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	public void save(CommodityForm form) {
		Commodity commodity = new Commodity();
		commodity.setId(form.getId());
		commodity.setBrand(form.getBrand());
		commodity.setCategory(form.getCategory());
		commodity.setColor(form.getColor());
		commodity.setMaterial(form.getMaterial());
		commodity.setPrice(Double.valueOf(form.getPrice().replace(',', '.')));
		commodityDao.saveAndFlush(commodity);
		if(fileWriter.write(Folder.COMMODITIES, form.getFile(), commodity.getId())){
			commodity.setVersion(commodity.getVersion()+1);
			commodityDao.save(commodity);
		}
	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}

	public CommodityForm findForm(int id) {
		Commodity commodity = findOne(id);
		CommodityForm form = new CommodityForm();
		form.setId(commodity.getId());
		form.setBrand(commodity.getBrand());
		form.setCategory(commodity.getCategory());
		form.setColor(commodity.getColor());
		form.setMaterial(commodity.getMaterial());
		form.setPrice(String.valueOf(commodity.getPrice()));
		return form;
	}

	public Commodity findUnique(Brand brand, Category category, Color color,
			Material material, String price) {
		return commodityDao.findUnique(brand.getId(), category.getId(), color.getId(), material.getId(), Double.valueOf(price.replace(',', '.')));
	}

	@Override
	public Page<Commodity> findAll(Pageable pageable, CommodityFilter filter) {
		return commodityDao.findAll(new CommoditySpecification(filter), pageable) ;
	}
	
}
