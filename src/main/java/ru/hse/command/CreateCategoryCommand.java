package ru.hse.command;

import ru.hse.domain.Category;
import ru.hse.services.CategoryService;

public class CreateCategoryCommand implements Command {
    private final CategoryService categoryService;
    private final Category.CategoryType type;
    private final String name;

    public CreateCategoryCommand(CategoryService categoryService, Category.CategoryType type, String name) {
        this.categoryService = categoryService;
        this.type = type;
        this.name = name;
    }

    @Override
    public void execute() {
        Category category = categoryService.createCategory(type, name);
        System.out.println("Created Category: " + category);
    }
}