package com.vuhocspring.validated_data.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return false;
        return s.startsWith(coursePrefix);
    }

    @Override
    public void initialize(CourseCode theCode) {
        coursePrefix = theCode.value();
    }
}
