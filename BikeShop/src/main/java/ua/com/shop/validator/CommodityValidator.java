package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.CommodityForm;
import ua.com.shop.service.CommodityService;

public class CommodityValidator implements Validator{

	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private CommodityService commodityService;

	public CommodityValidator(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public boolean supports(Class<?> clazz) {
		return CommodityForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		CommodityForm form = (CommodityForm) target;
		if(!REG.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Can separated by , or . or only numbers");
		}
		if(errors.getFieldError("price")==null){
			if(commodityService.findUnique(form.getBrand(), form.getCategory(), form.getColor(), form.getMaterial(), form.getPrice())!=null){
				errors.rejectValue("brand", "", "Already exist");
			}
		}
		
	}
	
	
	
}
