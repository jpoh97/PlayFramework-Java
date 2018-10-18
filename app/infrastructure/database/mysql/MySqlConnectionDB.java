package infrastructure.database.mysql;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.entity.Building;
import domain.repository.BuildingRepository;
import infrastructure.database.DatabaseExecutionContext;
import play.db.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class MySqlConnectionDB implements BuildingRepository {
    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public MySqlConnectionDB(@NamedDatabase("hoteldb") Database db, DatabaseExecutionContext context) {
        this.db = db;
        this.executionContext = context;
    }

    public CompletionStage<Integer> updateSomething() {
        return CompletableFuture.supplyAsync(() -> {
            return db.withConnection(connection -> {
                return 1;
            });
        }, executionContext);
    }

    @Override
    public Optional<Building> save(Building building) {
        db.withConnection(connection -> {

        });
        return Optional.empty();
    }

    @Override
    public Optional<Building> findById(String id) {
        return Optional.empty();
    }
}
