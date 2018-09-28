package application.responsemodel;

public class GetTenantResponse {

    private String tenantId;
    private String tenantName;

    public GetTenantResponse(String tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
