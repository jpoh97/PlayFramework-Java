package infrastructure.database.h2.jdbi;

import domain.entity.Tenant;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TenantJdbiMapper implements ResultSetMapper<Tenant> {

    public Tenant map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        String buildingId = r.getString("id");
        final String tenantName = r.getString("name");
        final Integer tenantAge = r.getInt("age");
        final LocalDate entryDate = r.getDate("entryDate").toLocalDate();
        return Tenant.of(buildingId, tenantName, tenantAge, entryDate);
    }
}
