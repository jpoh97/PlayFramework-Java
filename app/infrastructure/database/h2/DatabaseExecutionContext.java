package infrastructure.database.h2;

import akka.actor.ActorSystem;
import scala.concurrent.ExecutionContext;
import scala.concurrent.ExecutionContextExecutor;

import javax.inject.Inject;

public class DatabaseExecutionContext implements ExecutionContextExecutor {

    private final ExecutionContext executionContext;
    private static final String DATABASE_DISPATCHER = "database.dispatcher";

    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        this.executionContext = actorSystem.dispatchers().lookup(DATABASE_DISPATCHER);
    }

    public void execute(Runnable runnable) {
        executionContext.execute(runnable);
    }

    public void reportFailure(Throwable cause) {
        executionContext.reportFailure(cause);
    }

    public ExecutionContext prepare() {
        return executionContext.prepare();
    }
}
