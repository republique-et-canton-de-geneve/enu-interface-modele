package ch.ge.ael.enu.business.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates that field {@code dependFieldName} is not null if
 * field {@code fieldName} has value {@code fieldValue}.
 **/
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Repeatable(NullIfAnotherFieldIsNull.List.class) // only with hibernate-validator >= 6.x
@Constraint(validatedBy = NullIfAnotherFieldIsNullValidator.class)
@Documented
public @interface NullIfAnotherFieldIsNull {
    String fieldName();
    String[] dependFieldNames();

    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        NullIfAnotherFieldIsNull[] value();
    }
}
