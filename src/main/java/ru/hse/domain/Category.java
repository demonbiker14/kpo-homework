package ru.hse.domain;

import java.util.UUID;


public class Category {
    public enum CategoryType {
        INCOME, EXPENSE
    }

    private final UUID id;
    private final CategoryType type;
    private String name;

    public Category(CategoryType type, String name) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public CategoryType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }


}