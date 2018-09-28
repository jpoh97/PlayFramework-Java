package domain.services.buildingattendantvalidation;

import domain.entity.Building;
import domain.exception.BaseException;

public interface BuildingAttendantValidation {

    void execute(Building building) throws BaseException;

}
