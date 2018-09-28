package infrastructure.database.h2.jdbi;

import java.util.List;

import domain.entity.Tenant;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface TenantDao extends AutoCloseable {
    @SqlUpdate("INSERT INTO tenant(id, name, buildingId) VALUES (:t.id, :t.name, :buildingId)")
    void insert(@Bind("buildingId") String buildingId, @BindBean("t") Tenant tenant);

    @SqlUpdate("DELETE FROM tenant WHERE buildingId = :buildingId")
    void deleteAllForBuilding(@Bind("buildingId") String buildingId);

    @SqlUpdate("DELETE FROM tenant WHERE buildingId = :buildingId AND id = :t.id")
    void delete(@Bind("buildingId") String buildingId, @BindBean("t") Tenant tenant);

    @SqlQuery("SELECT id, name FROM tenant WHERE buildingId = :buildingId")
    @Mapper(TenantJdbiMapper.class)
    List<Tenant> getTenantsForBuilding(@Bind("buildingId")String buildingId);

    void close();
}
