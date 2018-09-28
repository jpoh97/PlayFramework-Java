package domain.entity;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Building {
    private String id;
    private String name;
    private List<Tenant> tenants;

    private Building(String id, String name, List<Tenant> tenants) {
        this.id = id;
        this.name = name;
        this.tenants = tenants;
    }

    public static Builder builder(String id, String name) {
        return new Builder(id, name);
    }

    public static class Builder {
        private String id;
        private String name;
        private List<Tenant> tenants = new ArrayList<>();

        private Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withTenants(List<Tenant> tenants) {
            checkNotNull(tenants);
            this.tenants = tenants;
            return this;
        }

        public Building build() {
            checkNotNull(id);
            checkNotNull(name);
            return new Building(id, name, tenants);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Tenant> getTenants() {
        return ImmutableList.copyOf(tenants);
    }

    public void addTenant(Tenant tenant) {
        this.tenants.add(tenant);
    }

    public Boolean evictTenant(String tenantId) {
        return this.tenants.removeIf(it -> it.getId().equals(tenantId));
    }
}
