package domain.services.buildingattendantvalidation.implementation;

import domain.entity.Building;
import domain.entity.Tenant;
import domain.exception.implementation.IllegalAgeException;
import domain.services.buildingattendantvalidation.BuildingAttendantValidation;

public class LegalAgeValidation implements BuildingAttendantValidation {

    public static final Integer LEGAL_AGE = 18;

    public void execute(Building building) throws IllegalAgeException {
        for (Tenant tenant : building.getTenants()) {
            if(LEGAL_AGE > tenant.getAge()) {
                throw new IllegalAgeException();
            }
        }
    }
}
