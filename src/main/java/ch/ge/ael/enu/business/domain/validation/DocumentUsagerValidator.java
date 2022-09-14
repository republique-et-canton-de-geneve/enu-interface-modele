package ch.ge.ael.enu.business.domain.validation;

import ch.ge.ael.enu.business.domain.v1_1.DocumentUsager;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentUsagerValidator implements
        ConstraintValidator<ValidDocumentUsager, DocumentUsager> {
    private static final String pipe = "|";

    @Override
    public void initialize(ValidDocumentUsager constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(DocumentUsager documentUsager, ConstraintValidatorContext context) {
        return !documentUsager.idDocumentSiMetier.isEmpty() &&
                !documentUsager.libelleDocument.isEmpty() &&
                !documentUsager.idDocumentSiMetier.contains(pipe) &&
                !documentUsager.libelleDocument.contains(pipe);
    }
}