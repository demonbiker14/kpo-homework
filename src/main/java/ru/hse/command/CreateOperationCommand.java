package ru.hse.command;

import ru.hse.domain.Operation;
import ru.hse.services.OperationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CreateOperationCommand implements Command {
    private final OperationService operationService;
    private final Operation.Type type;
    private final UUID accountId;
    private final BigDecimal amount;
    private final LocalDate date;
    private final String description;
    private final UUID categoryId;

    public CreateOperationCommand(
            OperationService operationService,
            Operation.Type type,
            UUID accountId,
            BigDecimal amount,
            LocalDate date,
            String description,
            UUID categoryId
    ) {
        this.operationService = operationService;
        this.type = type;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
    }

    @Override
    public void execute() {
        operationService.createOperation(type, accountId, amount, date, description, categoryId);
    }
}