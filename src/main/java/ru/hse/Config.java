package ru.hse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hse.services.AccountService;
import ru.hse.services.CategoryService;
import ru.hse.services.OperationService;
import ru.hse.facade.FinancialFacade;

@Configuration
public class Config {
    @Bean
    public AccountService accountService() {
        return new AccountService();
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryService();
    }

    @Bean
    public OperationService operationService() {
        return new OperationService();
    }

    @Bean
    public FinancialFacade financialFacade(AccountService accountService,
                                           CategoryService categoryService,
                                           OperationService operationService) {
        return new FinancialFacade(accountService, categoryService, operationService);
    }

}
