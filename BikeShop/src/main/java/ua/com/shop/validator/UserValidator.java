package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

public class UserValidator implements Validator {

	private UserService userService;

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Can't be empty");
		if(userService.findByEmail(user.getEmail())!=null){
			errors.rejectValue("email", "", "This user already exists");
		}
	}
	
	
}
