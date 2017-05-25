package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CommodityFilter {

	private String min = "";
	
	private String max = "";

	private double minValue;
	
	private double maxValue;
	
	private List<Integer> brandId = new ArrayList<>();
	
	private List<Integer> materialId = new ArrayList<>();
	
	private List<Integer> colorId = new ArrayList<>();
	
	private List<Integer> categoryId = new ArrayList<>();

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public List<Integer> getBrandId() {
		return brandId;
	}

	public void setBrandId(List<Integer> brandId) {
		this.brandId = brandId;
	}

	public List<Integer> getMaterialId() {
		return materialId;
	}

	public void setMaterialId(List<Integer> materialId) {
		this.materialId = materialId;
	}

	public List<Integer> getColorId() {
		return colorId;
	}

	public void setColorId(List<Integer> colorId) {
		this.colorId = colorId;
	}

	public List<Integer> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}

	
	
	
	
}
