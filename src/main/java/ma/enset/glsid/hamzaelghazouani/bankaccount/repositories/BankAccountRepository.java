package ma.enset.glsid.hamzaelghazouani.bankaccount.repositories;

import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByCustomerId(Long customerId);
}

