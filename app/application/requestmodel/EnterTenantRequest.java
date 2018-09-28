package application.requestmodel;

import com.google.common.base.Objects;

import javax.annotation.concurrent.Immutable;

import static com.google.common.base.Preconditions.checkNotNull;

@Immutable
public class EnterTenantRequest {

    private final String buildingId;
    private final String buildingName;
    private final String tenantId;
    private final String tenantName;
    private final Integer tenantAge;

    private EnterTenantRequest(String buildingId, String buildingName, String tenantId, String tenantName, Integer tenantAge) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantAge = tenantAge;
    }

    public static EnterTenantRequest of(String buildingId, String buildingName, String tenantId, String tenantName, Integer tenantAge) {
        checkNotNull(buildingId);
        checkNotNull(tenantId);
        checkNotNull(tenantName);
        checkNotNull(tenantAge);
        return new EnterTenantRequest(buildingId, buildingName, tenantId, tenantName, tenantAge);
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public Integer getTenantAge() {
        return tenantAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterTenantRequest that = (EnterTenantRequest) o;
        return Objects.equal(buildingId, that.buildingId) &&
                Objects.equal(buildingName, that.buildingName) &&
                Objects.equal(tenantId, that.tenantId) &&
                Objects.equal(tenantName, that.tenantName) &&
                Objects.equal(tenantAge, that.tenantAge);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buildingId, buildingName, tenantId, tenantName, tenantAge);
    }
}
