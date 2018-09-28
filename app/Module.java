import application.usecases.EnterTenant;
import application.usecases.EvictTenant;
import application.usecases.GetBuilding;
import application.usecases.implementation.EnterTenantImplementation;
import application.usecases.implementation.EvictTenantImplementation;
import application.usecases.implementation.GetBuildingImplementation;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import domain.repository.BuildingRepository;
import domain.services.BuildingAttendantService;
import domain.services.BuildingManagerService;
import domain.services.buildingattendantutil.BuildingCalendar;
import domain.services.buildingattendantutil.implementation.BuildingCalendarImplementation;
import domain.services.buildingattendantvalidation.BuildingAttendantValidation;
import domain.services.buildingattendantvalidation.implementation.LegalAgeValidation;
import domain.services.implementation.BuildingAttendantServiceImplementation;
import domain.services.implementation.BuildingManagerServiceImplementation;
import infrastructure.database.h2.JdbcBuildingRepository;
import infrastructure.database.localmemory.LocalMemoryRepository;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import play.Environment;

import javax.sql.DataSource;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {

        bind(GetBuilding.class).to(GetBuildingImplementation.class);
        bind(EnterTenant.class).to(EnterTenantImplementation.class);
        bind(EvictTenant.class).to(EvictTenantImplementation.class);

        bind(BuildingManagerService.class).to(BuildingManagerServiceImplementation.class);
        bind(BuildingAttendantService.class).to(BuildingAttendantServiceImplementation.class);

        bind(BuildingCalendar.class).to(BuildingCalendarImplementation.class);

        bind(BuildingRepository.class).to(LocalMemoryRepository.class);

    }

}
