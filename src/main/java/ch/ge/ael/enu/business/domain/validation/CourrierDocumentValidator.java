package ch.ge.ael.enu.business.domain.validation;

import ch.ge.ael.enu.business.domain.v1_1.CourrierDocument;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourrierDocumentValidator implements
        ConstraintValidator<ValidCourrierDocument, CourrierDocument> {
    private static final String pipe = "|";

    @Override
    public void initialize(ValidCourrierDocument constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CourrierDocument courrierDocument, ConstraintValidatorContext context) {
        return courrierDocument.idDocumentSiMetier != null && !courrierDocument.idDocumentSiMetier.isEmpty() &&
                courrierDocument.libelleDocument != null && !courrierDocument.libelleDocument.isEmpty() &&
                !courrierDocument.idDocumentSiMetier.contains(pipe) &&
                !courrierDocument.libelleDocument.contains(pipe);
    }
}