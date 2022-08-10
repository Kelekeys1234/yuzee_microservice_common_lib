package com.yuzee.common.lib.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy={})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp="^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$|", message = "UUID is not Valid")
@ReportAsSingleViolation
public @interface ValidUUID {
    String message() default "UUID is not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
