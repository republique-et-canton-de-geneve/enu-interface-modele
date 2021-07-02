package ch.ge.ael.enu.business.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines that a given String must be part of a given Enum: ex. @ValueOfEnum(enumClass = MyEnumType.class) String value
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    Class<? extends Enum<?>> enumClass();
    String message() default "la valeur doit faire partie de l'enum {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
