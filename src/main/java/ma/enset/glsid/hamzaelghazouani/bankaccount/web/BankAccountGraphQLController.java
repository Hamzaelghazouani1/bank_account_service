package ma.enset.glsid.hamzaelghazouani.bankaccount.web;

import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.Customer;
import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.BankAccountRepository;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class BankAccountGraphQLController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, 
                                        CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @MutationMapping
    public BankAccount addAccount(@Argument BankAccountDTO bankAccount) {
        BankAccount newAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccount.balance())
                .currency(bankAccount.currency())
                .type(AccountType.valueOf(bankAccount.type()))
                .build();
        return bankAccountRepository.save(newAccount);
    }

    @MutationMapping
    public BankAccount updateAccount(@Argument String id, @Argument BankAccountDTO bankAccount) {
        BankAccount existingAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
        
        if (bankAccount.balance() != null) {
            existingAccount.setBalance(bankAccount.balance());
        }
        if (bankAccount.currency() != null) {
            existingAccount.setCurrency(bankAccount.currency());
        }
        if (bankAccount.type() != null) {
            existingAccount.setType(AccountType.valueOf(bankAccount.type()));
        }
        
        return bankAccountRepository.save(existingAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    public record BankAccountDTO(Double balance, String currency, String type) {
    }
}

