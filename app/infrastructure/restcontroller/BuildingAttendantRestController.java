package infrastructure.restcontroller;

import application.requestmodel.EnterTenantRequest;
import application.requestmodel.EvictTenantRequest;
import application.usecases.EnterTenant;
import application.usecases.EvictTenant;
import application.usecases.GetBuilding;
import com.fasterxml.jackson.databind.JsonNode;
import domain.exception.BaseException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class BuildingAttendantRestController extends Controller {

    private final EnterTenant enterTenant;
    private final EvictTenant evictTenant;
    private final GetBuilding getBuilding;

    @Inject
    public BuildingAttendantRestController(EnterTenant enterTenant,
                                           EvictTenant evictTenant,
                                           GetBuilding getBuilding) {
        this.enterTenant = enterTenant;
        this.evictTenant = evictTenant;
        this.getBuilding = getBuilding;
    }

    public CompletionStage<Result> index() {
        return CompletableFuture.completedFuture(ok("U can do it Jp c:"));
    }

    public CompletionStage<Result> getById(String buildingId) throws BaseException {
        return CompletableFuture.completedFuture(ok(Json.toJson(getBuilding.execute(buildingId))));
    }

    public CompletionStage<Result> enterTenant() throws BaseException {
        JsonNode json = request().body().asJson();
        EnterTenantRequest enterTenantRequest = EnterTenantRequest.of(
                json.get("buildingId").asText(),
                json.get("buildingName").asText(),
                json.get("tenantId").asText(),
                json.get("tenantName").asText(),
                json.get("tenantAge").asInt());
        // enterTenantRequest = Json.fromJson(json, EnterTenantRequest.class);
        enterTenant.execute(enterTenantRequest);
        return CompletableFuture.completedFuture(created("Hosted tenant"));
    }

    public CompletionStage<Result> evictTenant() {
        JsonNode json = request().body().asJson();
        EvictTenantRequest evictTenantRequest = EvictTenantRequest.of(
                json.get("buildingId").asText(),
                json.get("tenantId").asText()
        );
        evictTenant.execute(evictTenantRequest);
        return CompletableFuture.completedFuture(Results.ok("Tenant evicted"));
    }
}
