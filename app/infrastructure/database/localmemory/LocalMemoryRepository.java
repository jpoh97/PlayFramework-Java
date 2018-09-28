package infrastructure.database.localmemory;

import domain.entity.Building;
import domain.repository.BuildingRepository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class LocalMemoryRepository implements BuildingRepository {

    private List<Building> buildings = new ArrayList<>();

    @Override
    public Optional<Building> save(Building building) {
        buildings.add(building);
        return Optional.ofNullable(building);
    }

    @Override
    public Optional<Building> findById(String id) {
        for (Building building : buildings) {
            if (building.getId().equalsIgnoreCase(id)) {
                System.out.println("building found");
                return Optional.ofNullable(building);
            }
        }
        return Optional.empty();
    }
}
