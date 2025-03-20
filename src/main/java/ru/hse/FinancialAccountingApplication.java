package ru.hse;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.hse.facade.FinancialFacade;

@SpringBootApplication
public class FinancialAccountingApplication implements CommandLineRunner {
    private final FinancialFacade financialFacade;

    public FinancialAccountingApplication(FinancialFacade financialFacade) {
        this.financialFacade = financialFacade;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinancialAccountingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.financialFacade.runConsole();
    }
}