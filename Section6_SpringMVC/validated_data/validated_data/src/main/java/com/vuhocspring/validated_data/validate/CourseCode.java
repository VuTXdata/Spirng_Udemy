package com.vuhocspring.validated_data.validate;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Lớp mà annotation ràng buộc về mặt logic
@Target({ElementType.FIELD, ElementType.METHOD}) // annotation này được dùng cho những trường nào?
@Retention(RetentionPolicy.RUNTIME) // annotation sẽ được biên dịch để trở thành mã bytecode cùng chương trình.
public @interface CourseCode {

    String value() default "LUV";
    String message() default "must start with LUV";
    Class<?>[] groups() default {};  // tam thời hiểu là group các ràng buộc liên quan
    Class<? extends Payload>[] payload() default {}; // hiểu tạm thời là hiện thị lỗi
}
