package application.requestmodel;

import com.google.common.base.Objects;

import javax.annotation.concurrent.Immutable;

import static com.google.common.base.Preconditions.checkNotNull;

@Immutable
public class EvictTenantRequest {

    private final String buildingId;
    private final String tenantId;

    private EvictTenantRequest(String buildingId, String tenantId) {
        this.buildingId = buildingId;
        this.tenantId = tenantId;
    }

    public static EvictTenantRequest of(String buildingId, String tenantId) {
        checkNotNull(buildingId);
        checkNotNull(tenantId);
        return new EvictTenantRequest(buildingId, tenantId);
    }

    public String getBuildingId() {
        return buildingId;
    }

    public String getTenantId() {
        return tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvictTenantRequest that = (EvictTenantRequest) o;
        return Objects.equal(buildingId, that.buildingId) &&
                Objects.equal(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buildingId, tenantId);
    }
}
