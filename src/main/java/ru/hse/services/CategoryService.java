package ru.hse.services;

import ru.hse.domain.Category;
import ru.hse.domain.DomainObjectFactory;

import java.util.*;

public class CategoryService {
    private final Map<UUID, Category> categoryMap = new HashMap<>();

    public Category createCategory(Category.CategoryType type, String name) {
        Category category = DomainObjectFactory.createCategory(type, name);
        categoryMap.put(category.getId(), category);
        return category;
    }

    public Category getCategory(UUID id) {
        return categoryMap.get(id);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categoryMap.values());
    }

    public void deleteCategory(UUID id) {
        categoryMap.remove(id);
    }
}