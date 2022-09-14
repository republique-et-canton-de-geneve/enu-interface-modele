package ch.ge.ael.enu.business.domain.validation;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DocumentUsagerValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface ValidDocumentUsager {

    String message() default "L'idDocumentSiMetier ou le libelleDocument du document n'est pas valide";

    Class[] groups() default {};

    Class[] payload() default {};
}