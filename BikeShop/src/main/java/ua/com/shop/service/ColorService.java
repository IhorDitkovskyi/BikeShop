package ua.com.shop.service;

import java.util.List;


import ua.com.shop.entity.Color;

public interface ColorService {

	void save(Color color);

	List<Color> findAll();

	Color findOne(int id);

	void delete(int id);
	
}
