package domain.entity;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkNotNull;

public class Tenant {
    private String id;
    private String name;
    private Integer age;
    private LocalDate entryDate;

    private Tenant(String id, String name, Integer age, LocalDate entryDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.entryDate = entryDate;
    }

    public static Tenant of(String id, String name, Integer age, LocalDate entryDate) {
        checkNotNull(id); // IllegalStateException
        checkNotNull(name);
        checkNotNull(age);
        checkNotNull(entryDate);
        return new Tenant(id, name, age, entryDate);
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
