package ru.hse.facade;

import ru.hse.command.CreateBankAccountCommand;
import ru.hse.command.CreateCategoryCommand;
import ru.hse.command.CreateOperationCommand;
import ru.hse.command.TimingCommandDecorator;
import ru.hse.domain.Operation;
import ru.hse.services.AccountService;
import ru.hse.services.CategoryService;
import ru.hse.services.OperationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class FinancialFacade {

    private final AccountService accountService;
    private final CategoryService categoryService;
    private final OperationService operationService;

    public FinancialFacade(
            AccountService accountService, CategoryService categoryService, OperationService operationService
    ) {
        this.accountService = accountService;
        this.categoryService = categoryService;
        this.operationService = operationService;
    }

    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Выберите опцию: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createAccount(scanner);
                    break;
                case "2":
                    createCategory(scanner);
                    break;
                case "3":
                    createOperation(scanner);
                    break;
                case "4":
                    listAccounts();
                    break;
                case "5":
                    listCategories();
                    break;
                case "6":
                    listOperations();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная опция.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Финансовый учёт ---");
        System.out.println("1. Создать счёт");
        System.out.println("2. Создать категорию");
        System.out.println("3. Создать операцию");
        System.out.println("4. Список счетов");
        System.out.println("5. Список категорий");
        System.out.println("6. Список операций");
        System.out.println("0. Выход");
    }

    private void createAccount(Scanner scanner) {
        System.out.print("Введите название счёта: ");
        String name = scanner.nextLine();
        System.out.print("Введите начальный баланс: ");
        BigDecimal balance = new BigDecimal(scanner.nextLine());
        CreateBankAccountCommand command = new CreateBankAccountCommand(accountService, name, balance);
        new TimingCommandDecorator(command).execute();
    }

    private void createCategory(Scanner scanner) {
        System.out.print("Введите название категории: ");
        String name = scanner.nextLine();
        System.out.print("Введите тип категории (INCOME/EXPENSE): ");
        String typeStr = scanner.nextLine().toUpperCase();
        CreateCategoryCommand command = new CreateCategoryCommand(categoryService,
                "INCOME".equals(typeStr) ? ru.hse.domain.Category.CategoryType.INCOME : ru.hse.domain.Category.CategoryType.EXPENSE, name);
        new TimingCommandDecorator(command).execute();
    }

    private void createOperation(Scanner scanner) {
        System.out.print("Введите тип операции (INCOME/EXPENSE): ");
        String typeStr = scanner.nextLine().toUpperCase();
        System.out.print("Введите ID счета: ");
        UUID accountId = UUID.fromString(scanner.nextLine());
        System.out.print("Введите сумму: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());
        System.out.print("Введите дату (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите описание: ");
        String description = scanner.nextLine();
        System.out.print("Введите ID категории: ");
        UUID categoryId = UUID.fromString(scanner.nextLine());
        CreateOperationCommand command = new CreateOperationCommand(
                operationService,
                "INCOME".equals(typeStr) ? Operation.Type.INCOME : Operation.Type.EXPENSE,
                accountId, amount, date, description, categoryId
        );
        new TimingCommandDecorator(command).execute();
    }

    private void listAccounts() {
        System.out.println("Счета:");
        accountService.getAllAccounts().forEach(System.out::println);
    }

    private void listCategories() {
        System.out.println("Категории:");
        categoryService.getAllCategories().forEach(System.out::println);
    }

    private void listOperations() {
        System.out.println("Операции:");
        operationService.getAllOperations().forEach(System.out::println);
    }
}