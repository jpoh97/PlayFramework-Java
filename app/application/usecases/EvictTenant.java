package application.usecases;

import application.requestmodel.EvictTenantRequest;

@FunctionalInterface
@UseCase
public interface EvictTenant {
    void execute(EvictTenantRequest request);
}
