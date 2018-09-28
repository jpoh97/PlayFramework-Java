package domain.repository;

import domain.entity.Building;

import java.util.Optional;

public interface BuildingRepository {

    Optional<Building> save(Building building);

    Optional<Building> findById(String id);

}
