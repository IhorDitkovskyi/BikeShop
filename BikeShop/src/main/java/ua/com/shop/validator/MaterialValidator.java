package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

public class MaterialValidator implements Validator{

	private MaterialService materialService;

	public MaterialValidator(MaterialService materialService) {
		this.materialService = materialService;
	}

	public boolean supports(Class<?> clazz) {
		return Material.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Material material = (Material) target;
		ValidationUtils.rejectIfEmpty(errors, "material", "", "Can't be empty");
		if(materialService.findByMaterial(material.getMaterial())!=null){
			errors.rejectValue("material", "", "Already exist");
		}
	}

}
