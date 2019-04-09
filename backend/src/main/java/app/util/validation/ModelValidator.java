package app.util.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import app.exception.ValidationException;

public class ModelValidator {

	public static <T> void validate(T model) {

		Set<ConstraintViolation<T>> errors = runValidations(model);
		
		if (errors != null && !errors.isEmpty()) {
			
			throw new ValidationException(errors);
		}
	}
	
	public static <T> boolean isValid(T model) {
	
		Set<ConstraintViolation<T>> errors = runValidations(model);
		
		return errors == null || errors.isEmpty();
	}
	
	private static <T> Set<ConstraintViolation<T>> runValidations(T model) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		return validator.validate(model);
	}
	

}
