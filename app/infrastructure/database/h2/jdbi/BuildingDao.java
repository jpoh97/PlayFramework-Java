package infrastructure.database.h2.jdbi;

import domain.entity.Building;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface BuildingDao extends AutoCloseable {

    @SqlUpdate("create table building (id int primary key, name varchar(100))")
    void createBuildingTable();

    @SqlUpdate("INSERT INTO building(id, name) VALUES (:b.id, :b.name)")
    void insert(@BindBean("b") Building building);

    @SqlQuery("SELECT id, name FROM building WHERE id = :id")
    @Mapper(BuildingJdbiMapper.class)
    Building findById(@Bind("id") String id);

    @SqlUpdate("UPDATE building SET name = :b.name")
    void update(@BindBean("b") Building building);

    void close();

}
