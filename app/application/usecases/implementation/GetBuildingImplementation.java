package application.usecases.implementation;

import application.responsemodel.GetBuildingResponse;
import application.responsemodel.GetTenantResponse;
import application.usecases.GetBuilding;
import domain.entity.Building;
import domain.entity.Tenant;
import domain.exception.BaseException;
import domain.services.BuildingManagerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@Singleton
public class GetBuildingImplementation implements GetBuilding {

    private final BuildingManagerService buildingManager;

    @Inject
    public GetBuildingImplementation(BuildingManagerService buildingManager) {
        this.buildingManager = buildingManager;
    }

    public GetBuildingResponse execute(String buildingId) throws BaseException {
        Optional<Building> building = buildingManager.getBuilding(buildingId);
        if (!building.isPresent()) {
            System.out.println("----------------Alv----------------");
            throw new IllegalArgumentException();
        }
        List<GetTenantResponse> tenants = building.get().getTenants().stream().map(this::toResponseModel).collect(toList());
        // TenantMapper.INSTANCE.tenantListToDtoList(building.get().getTenants());
        return new GetBuildingResponse(building.get().getName(), tenants);
    }

    private GetTenantResponse toResponseModel(Tenant tenant) {
        return new GetTenantResponse(tenant.getId(), tenant.getName());
    }
}
