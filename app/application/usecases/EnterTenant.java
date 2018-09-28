package application.usecases;

import application.requestmodel.EnterTenantRequest;
import domain.exception.BaseException;

@FunctionalInterface
@UseCase
public interface EnterTenant {
    void execute(EnterTenantRequest request) throws BaseException;
}
