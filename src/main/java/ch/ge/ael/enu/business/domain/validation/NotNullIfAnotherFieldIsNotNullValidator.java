package ch.ge.ael.enu.business.domain.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Implementation of {@link NotNullIfAnotherFieldIsNotNull} validator.
 **/
public class NotNullIfAnotherFieldIsNotNullValidator implements ConstraintValidator<NotNullIfAnotherFieldIsNotNull, Object> {
    private String fieldName;
    private String[] dependFieldNames;

    @Override
    public void initialize(NotNullIfAnotherFieldIsNotNull constraintAnnotation) {
        fieldName          = constraintAnnotation.fieldName();
        dependFieldNames    = constraintAnnotation.dependFieldNames();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean result = true;
        try {
            String fieldValue       = BeanUtils.getProperty(value, fieldName);
            String dependFieldValue;
            for (String field : dependFieldNames) {
                dependFieldValue = BeanUtils.getProperty(value, field);
                if (fieldValue != null && dependFieldValue == null) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                            .addPropertyNode(field)
                            .addConstraintViolation();
                    result=false;
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }
}
