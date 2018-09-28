package domain.services.implementation;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.inject.Inject;
import domain.entity.Building;
import domain.entity.Tenant;
import domain.exception.BaseException;
import domain.repository.BuildingRepository;
import domain.services.BuildingAttendantService;
import domain.services.buildingattendantutil.BuildingCalendar;
import domain.services.buildingattendantvalidation.BuildingAttendantValidation;
import domain.services.buildingattendantvalidation.implementation.InvalidDayValidation;
import domain.services.buildingattendantvalidation.implementation.LegalAgeValidation;

import java.util.List;
import java.util.Optional;

public class BuildingAttendantServiceImplementation implements BuildingAttendantService {

    private final BuildingRepository buildingRepository;
    private final BuildingCalendar buildingCalendar;
    //private final List<BuildingAttendantValidation> entryValidations;
    private final InvalidDayValidation invalidDayValidation;
    private final LegalAgeValidation legalAgeValidation;

    @Inject
    public BuildingAttendantServiceImplementation(BuildingRepository buildingRepository,
                                                  BuildingCalendar buildingCalendar,
                                                  //List<BuildingAttendantValidation> entryValidations,
                                                  InvalidDayValidation invalidDayValidation,
                                                  LegalAgeValidation legalAgeValidation) {
        this.buildingRepository = buildingRepository;
        this.buildingCalendar = buildingCalendar;
        this.invalidDayValidation = invalidDayValidation;
        this.legalAgeValidation = legalAgeValidation;
        //this.entryValidations = entryValidations;
    }

    public Optional<Building> checkIn(String buildingId, String buildingName, String tenantId, String tenantName, Integer tenantAge) throws BaseException {
        validateBuildingAndTenantId(buildingId, tenantId);
        Optional<Building> building = buildingRepository.findById(buildingId);
        if (!building.isPresent()) {
            Building newBuilding = Building.builder(buildingId, buildingName).build();
            building = Optional.of(newBuilding);
            //throw new IllegalArgumentException();
        }
        invalidDayValidation.execute(building.get());
        legalAgeValidation.execute(building.get());
        /*for (BuildingAttendantValidation validation : entryValidations) {
            validation.execute(building.get());
        }*/
        var tenant = Tenant.of(tenantId, tenantName, tenantAge, buildingCalendar.getCurrentDate());
        building.get().addTenant(tenant);
        return buildingRepository.save(building.get());
    }

    public Optional<Building> checkOut(String buildingId, String tenantId) {
        validateBuildingAndTenantId(buildingId, tenantId);
        Optional<Building> building = buildingRepository.findById(buildingId);
        building.ifPresent(buildingResponse -> buildingResponse.evictTenant(tenantId));
        return building;
    }

    private void validateBuildingAndTenantId(String buildingId, String tenantId) {
        checkNotNull(buildingId);
        checkNotNull(tenantId);
    }
}
