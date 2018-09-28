package domain.services;

import domain.entity.Building;
import domain.exception.BaseException;

import java.util.Optional;

public interface BuildingAttendantService {

    Optional<Building> checkIn(String buildingId, String buildingName, String tenantId, String tenantName, Integer tenantAge) throws BaseException;

    Optional<Building> checkOut(String buildingId, String tenantId);

}
