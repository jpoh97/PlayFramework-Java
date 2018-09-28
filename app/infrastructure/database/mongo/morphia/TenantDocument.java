package infrastructure.database.mongo.morphia;

import org.mongodb.morphia.annotations.Id;

import java.time.LocalDate;

public class TenantDocument {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDate entryDate;

    protected TenantDocument() {}

    public TenantDocument(String id, String name, Integer age, LocalDate entryDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.entryDate = entryDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}
