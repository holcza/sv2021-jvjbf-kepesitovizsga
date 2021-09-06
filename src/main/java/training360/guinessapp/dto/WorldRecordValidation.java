package training360.guinessapp.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = WorldRecordValidator.class)
public @interface WorldRecordValidation {

    String message() default "Can not beat";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
