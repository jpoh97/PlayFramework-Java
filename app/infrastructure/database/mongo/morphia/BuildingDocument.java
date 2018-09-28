package infrastructure.database.mongo.morphia;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.List;

public class BuildingDocument {

    @Id
    private String id;
    private String name;
    @Embedded
    private List<TenantDocument> tenants = new ArrayList<>();

    protected BuildingDocument() {
    }

    public BuildingDocument(String id, String name, List<TenantDocument> tenants) {
        this.id = id;
        this.name = name;
        this.tenants = tenants;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TenantDocument> getTenants() {
        return tenants;
    }
}
