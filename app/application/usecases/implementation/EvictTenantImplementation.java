package application.usecases.implementation;

import application.requestmodel.EvictTenantRequest;
import application.usecases.EvictTenant;
import domain.services.BuildingAttendantService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import static com.google.common.base.Preconditions.checkNotNull;

@Transactional
@Named
public class EvictTenantImplementation implements EvictTenant {

    private final BuildingAttendantService buildingAttendant;

    @Inject
    public EvictTenantImplementation(BuildingAttendantService buildingAttendant) {
        this.buildingAttendant = buildingAttendant;
    }

    public void execute(EvictTenantRequest request) {
        checkNotNull(request);
        buildingAttendant.checkOut(request.getBuildingId(), request.getTenantId());
    }
}
