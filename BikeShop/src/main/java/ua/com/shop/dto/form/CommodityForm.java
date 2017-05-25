package ua.com.shop.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Brand;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Material;


public class CommodityForm {

	
	private int id;
	
	private String price;
	
	private Material material;
	
	private Category category;
	
	private Color color;
	
	private Brand brand;
	
	private MultipartFile file;
	
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
