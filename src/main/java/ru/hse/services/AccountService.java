package ru.hse.services;

import ru.hse.domain.BankAccount;
import ru.hse.domain.DomainObjectFactory;

import java.math.BigDecimal;
import java.util.*;

public class AccountService {
    private final Map<UUID, BankAccount> accountMap = new HashMap<>();

    public BankAccount createAccount(String name, BigDecimal initialBalance) {
        BankAccount account = DomainObjectFactory.createBankAccount(name, initialBalance);
        accountMap.put(account.getId(), account);
        return account;
    }

    public BankAccount getAccount(UUID id) {
        return accountMap.get(id);
    }

    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accountMap.values());
    }

    public void deleteAccount(UUID id) {
        accountMap.remove(id);
    }
}