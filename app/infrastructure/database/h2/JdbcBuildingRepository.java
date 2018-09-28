package infrastructure.database.h2;

import domain.entity.Building;
import domain.entity.Tenant;
import domain.repository.BuildingRepository;
import infrastructure.database.h2.jdbi.BuildingDao;
import infrastructure.database.h2.jdbi.TenantDao;
import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Singleton
public class JdbcBuildingRepository implements BuildingRepository {

    private DBI dbi;
    private  DatabaseExecutionContext executionContext;

    /*@Inject
    public JdbcBuildingRepository(DatabaseExecutionContext executionContext) {
        this.executionContext = executionContext;
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test",
                "sa",
                "");
        this.dbi = new DBI(ds);

        try (BuildingDao dao = dbi.open(BuildingDao.class)) {
            dao.createBuildingTable();
        }
    }*/

    public Optional<Building> save(Building building) {
        final Optional<Building> byId = findById(building.getId());
        if (byId.isPresent()) {
            return Optional.ofNullable(insert(building));
        } else {
            return Optional.ofNullable(update(building));
        }
    }

    public Optional<Building> findById(String buildingId) {
        try(BuildingDao buildingDao = dbi.open(BuildingDao.class)) {
            final Building building = buildingDao.findById(buildingId);
            if (building != null) {
                findTenantsByBuildingId(buildingId).forEach(building::addTenant);
            }
            return Optional.ofNullable(building);
        }
    }

    private Building insert(Building building) {
        try(BuildingDao buildingDao = dbi.open(BuildingDao.class)) {
            buildingDao.insert(building);
            saveTenants(building);
            return building;
        }
    }

    private Building update(Building building) {
        try(BuildingDao buildingDao = dbi.open(BuildingDao.class)) {
            buildingDao.update(building);
            saveTenants(building);
            return building;
        }
    }

    private void saveTenants(Building building) {
        try(TenantDao tenantDao = dbi.open(TenantDao.class)) {
            tenantDao.deleteAllForBuilding(building.getId());
            building.getTenants().forEach(it -> insert(building.getId(), it));
        }
    }

    private Tenant insert(String buildingId, Tenant tenant) {
        try(TenantDao tenantDao = dbi.open(TenantDao.class)) {
            tenantDao.insert(buildingId, tenant);
            return tenant;
        }
    }

    private List<Tenant> findTenantsByBuildingId(String buildingId) {
        try(TenantDao tenantDao = dbi.open(TenantDao.class)) {
            return tenantDao.getTenantsForBuilding(buildingId);
        }
    }
}
