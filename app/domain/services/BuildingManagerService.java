package domain.services;

import domain.entity.Building;

import java.util.Optional;

public interface BuildingManagerService {
    Optional<Building> getBuilding(String buildingId);
}
