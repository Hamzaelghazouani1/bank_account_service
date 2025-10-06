package ma.enset.glsid.hamzaelghazouani.bankaccount;

import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.Customer;
import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.BankAccountRepository;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository) {
        return args -> {
            Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .createdAt(new Date())
                            .balance(Math.random() * 100000)
                            .currency("MAD")
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }
}

