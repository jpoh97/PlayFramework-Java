package domain.exception.implementation;

import domain.exception.BaseException;
import domain.services.buildingattendantvalidation.implementation.LegalAgeValidation;

public class IllegalAgeException extends BaseException {
    public IllegalAgeException() {
        super(String.format("Tenants must be over %d years old", LegalAgeValidation.LEGAL_AGE));
    }
}
