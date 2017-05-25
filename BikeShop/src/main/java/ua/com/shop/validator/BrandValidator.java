package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Brand;
import ua.com.shop.service.BrandService;

public class BrandValidator implements Validator{

	private BrandService brandService;

	public BrandValidator(BrandService brandService) {
		this.brandService = brandService;
	}

	public boolean supports(Class<?> clazz) {
		return Brand.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Brand brand = (Brand) target;
		ValidationUtils.rejectIfEmpty(errors, "brand", "", "Can't be empty");
		if(brandService.findByBrand(brand.getBrand())!=null){
			errors.rejectValue("brand", "", "Already exist");
		}
	}
	
	
}
