package infrastructure.database.h2.jdbi;

import domain.entity.Building;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingJdbiMapper implements ResultSetMapper<Building> {

    public Building map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        final String buildingId = r.getString("id");
        final String buildingName = r.getString("name");
        return Building.builder(buildingId, buildingName).build();
    }
}
