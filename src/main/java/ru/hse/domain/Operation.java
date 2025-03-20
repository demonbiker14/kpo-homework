package ru.hse.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class Operation {
    public enum Type {
        INCOME, EXPENSE
    }

    private final UUID id;
    private final Type type;
    private final UUID bankAccountId;
    private final BigDecimal amount;
    private final LocalDate date;
    private final String description;
    private final UUID categoryId;

    public Operation(Type type, UUID bankAccountId, BigDecimal amount, LocalDate date, String description, UUID categoryId) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Operation amount cannot be negative");
        }
        this.id = UUID.randomUUID();
        this.type = type;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
    }

    public UUID getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public UUID getBankAccountId() {
        return bankAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCategoryId() {
        return categoryId;
    }



    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", type=" + type +
                ", bankAccountId=" + bankAccountId +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}

