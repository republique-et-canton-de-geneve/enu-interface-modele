package ch.ge.ael.enu.business.domain.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Implementation of {@link NotNullIfAnotherFieldHasValue} validator.
 **/
public class NotNullIfAnotherFieldHasValueValidator implements ConstraintValidator<NotNullIfAnotherFieldHasValue, Object> {
    private String fieldName;
    private String expectedFieldValue;
    private String[] dependFieldNames;

    @Override
    public void initialize(NotNullIfAnotherFieldHasValue constraintAnnotation) {
        fieldName          = constraintAnnotation.fieldName();
        expectedFieldValue = constraintAnnotation.fieldValue();
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
                if (expectedFieldValue.equals(fieldValue) && dependFieldValue == null) {
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
