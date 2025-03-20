package ru.hse.services;

import org.springframework.stereotype.Service;
import ru.hse.domain.DomainObjectFactory;
import ru.hse.domain.Operation;

import java.math.BigDecimal;
import java.util.*;


@Service
public class OperationService {
    private final Map<UUID, Operation> operationMap = new HashMap<>();

    public Operation createOperation(
            Operation.Type type,
            UUID bankAccountId,
            BigDecimal amount,
            java.time.LocalDate date,
            String description,
            UUID categoryId
    ) {
        Operation operation = DomainObjectFactory.createOperation(
                type, bankAccountId, amount, date, description, categoryId
        );
        operationMap.put(operation.getId(), operation);
        return operation;
    }

    public Operation getOperation(UUID id) {

        return operationMap.get(id);
    }


    public void deleteOperation(UUID id) {
        operationMap.remove(id);
    }

    public List<Operation> getAllOperations() {
        return new ArrayList<>(operationMap.values());
    }
}