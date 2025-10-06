package ma.enset.glsid.hamzaelghazouani.bankaccount.projections;

import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = BankAccount.class)
public interface AccountProjection {
    String getId();
    AccountType getType();
}

