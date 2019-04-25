package com.finalproject.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;



public class FieldMatcherValidator implements ConstraintValidator<FieldMatcher, Object> {

	
	
	
	
	private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatcher constraintAnnotation) {
	    	firstFieldName = constraintAnnotation.first();
	    	secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }
    
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		 boolean valid = true;
	        try
	        {
	            final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
	            final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);

	            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
	        }
	        catch (final Exception ignore)
	        {
	            // we can ignore
	        }

	        if (!valid){
	            context.buildConstraintViolationWithTemplate(message)
	                    .addPropertyNode(firstFieldName)
	                    .addConstraintViolation()
	                    .disableDefaultConstraintViolation();
	        }

	        return valid;
	}

}
