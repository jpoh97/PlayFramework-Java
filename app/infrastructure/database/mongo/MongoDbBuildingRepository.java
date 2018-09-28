package infrastructure.database.mongo;

import domain.entity.Building;
import domain.entity.Tenant;
import domain.repository.BuildingRepository;
import infrastructure.database.mongo.morphia.BuildingDocument;
import infrastructure.database.mongo.morphia.TenantDocument;
import org.mongodb.morphia.Datastore;

import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class MongoDbBuildingRepository implements BuildingRepository {

    private final Datastore datastore;

    public MongoDbBuildingRepository(Datastore datastore) {
        this.datastore = datastore;
    }

    public Optional<Building> save(Building building) {
        datastore.save(toDocument(building));
        return Optional.ofNullable(building);
    }

    public Optional<Building> findById(String id) {
        return Optional.ofNullable(toDomain(datastore.get(BuildingDocument.class, id)));
    }

    private Building toDomain(BuildingDocument buildingDocument)  {
        return Building.builder(buildingDocument.getId(), buildingDocument.getName())
                .withTenants(buildingDocument.getTenants().stream().map(this::toDomain).collect(toList())).build();
    }

    private Tenant toDomain(TenantDocument tenantDocument) {
        return Tenant.of(tenantDocument.getId(), tenantDocument.getName(), tenantDocument.getAge(), tenantDocument.getEntryDate());
    }

    private BuildingDocument toDocument(Building building)  {
        return new BuildingDocument(building.getId(), building.getName(),
                building.getTenants().stream().map(this::toDocument).collect(toList()));
    }

    private TenantDocument toDocument(Tenant tenant)  {
        return new TenantDocument(tenant.getId(), tenant.getName(), tenant.getAge(), tenant.getEntryDate());
    }
}
