package ru.hse.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DomainObjectFactory {
    public static BankAccount createBankAccount(String name, BigDecimal initialBalance) {
        return new BankAccount(name, initialBalance);
    }

    public static Category createCategory(Category.CategoryType type, String name) {
        return new Category(type, name);
    }

    public static Operation createOperation(
            Operation.Type type,
            UUID accountId,
            BigDecimal amount,
            LocalDate date,
            String description,
            UUID categoryId
    ) {
        return new Operation(type, accountId,  amount, date, description, categoryId);
    }
}
