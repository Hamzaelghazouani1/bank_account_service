package ma.enset.glsid.hamzaelghazouani.bankaccount.repositories;

import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

