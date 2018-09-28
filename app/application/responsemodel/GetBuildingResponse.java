package application.responsemodel;

import com.google.common.base.Objects;

import java.util.List;

public class GetBuildingResponse {

    private  String buildingName;
    private  List<GetTenantResponse> tenants;

    public GetBuildingResponse(String buildingName, List<GetTenantResponse> tenants) {
        this.buildingName = buildingName;
        this.tenants = tenants;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public List<GetTenantResponse> getTenants() {
        return tenants;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setTenants(List<GetTenantResponse> tenants) {
        this.tenants = tenants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetBuildingResponse that = (GetBuildingResponse) o;
        return Objects.equal(buildingName, that.buildingName) &&
                Objects.equal(tenants, that.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buildingName, tenants);
    }

    @Override
    public String toString() {
        return "GetBuildingResponse{" +
                "buildingName='" + buildingName + '\'' +
                ", tenants=" + tenants +
                '}';
    }
}
