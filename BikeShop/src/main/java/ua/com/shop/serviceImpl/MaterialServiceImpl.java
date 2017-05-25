package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MaterialDao;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialDao materialDao;

	@Override
	public void save(Material material) {
		materialDao.save(material);

	}

	@Override
	public List<Material> findAll() {
		return materialDao.findAll();

	}

	@Override
	public Material findOne(int id) {
		return materialDao.findOne(id);

	}

	@Override
	public void delete(int id) {
		materialDao.delete(id);
	}

	@Override
	public Material findByMaterial(String material) {
		return materialDao.findByMaterial(material);
	}

}
