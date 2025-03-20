package ru.hse.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private final UUID id;
    private String name;
    private BigDecimal balance;

    public BankAccount(String name, BigDecimal initialBalance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.balance = initialBalance;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", name='" + name + '\'' + ", balance=" + balance + '}';
    }
}
