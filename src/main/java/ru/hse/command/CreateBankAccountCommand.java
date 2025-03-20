package ru.hse.command;

import ru.hse.domain.BankAccount;
import ru.hse.services.AccountService;

import java.math.BigDecimal;

public class CreateBankAccountCommand implements Command {
    private final AccountService accountService;
    private final String name;
    private final BigDecimal initialBalance;

    public CreateBankAccountCommand(AccountService accountService, String name, BigDecimal initialBalance) {
        this.accountService = accountService;
        this.name = name;
        this.initialBalance = initialBalance;
    }

    @Override
    public void execute() {
        BankAccount account = accountService.createAccount(name, initialBalance);
        System.out.println("Created Account: " + account);
    }
}