package domain.services.implementation;

import domain.entity.Building;
import domain.repository.BuildingRepository;
import domain.services.BuildingManagerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class BuildingManagerServiceImplementation implements BuildingManagerService {

    private final BuildingRepository buildingRepository;

    @Inject
    public BuildingManagerServiceImplementation(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Optional<Building> getBuilding(String buildingId) {
        return buildingRepository.findById(buildingId);
    }
}
