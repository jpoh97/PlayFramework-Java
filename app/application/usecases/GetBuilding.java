package application.usecases;

import application.responsemodel.GetBuildingResponse;
import domain.exception.BaseException;

@FunctionalInterface
@UseCase
public interface GetBuilding {
    GetBuildingResponse execute(String buildingId) throws BaseException;
}
