package application.usecases.implementation;

import application.requestmodel.EnterTenantRequest;
import application.usecases.EnterTenant;
import domain.exception.BaseException;
import domain.services.BuildingAttendantService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import static com.google.common.base.Preconditions.checkNotNull;

@Transactional
@Named
public class EnterTenantImplementation implements EnterTenant {

    private final BuildingAttendantService buildingAttendant;

    @Inject
    public EnterTenantImplementation(BuildingAttendantService buildingAttendant) {
        this.buildingAttendant = buildingAttendant;
    }

    public void execute(EnterTenantRequest request) throws BaseException {
        checkNotNull(request);
        buildingAttendant.checkIn(request.getBuildingId(), request.getBuildingName(), request.getTenantId(), request.getTenantName(), request.getTenantAge());
    }
}
