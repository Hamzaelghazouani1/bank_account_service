package ma.enset.glsid.hamzaelghazouani.bankaccount.entities;

import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

    public BankAccount() {
    }

    public BankAccount(String id, Date createdAt, Double balance, String currency, AccountType type, Customer customer) {
        this.id = id;
        this.createdAt = createdAt;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.customer = customer;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public AccountType getType() { return type; }
    public void setType(AccountType type) { this.type = type; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public static BankAccountBuilder builder() { return new BankAccountBuilder(); }

    public static class BankAccountBuilder {
        private String id;
        private Date createdAt;
        private Double balance;
        private String currency;
        private AccountType type;
        private Customer customer;

        public BankAccountBuilder id(String id) { this.id = id; return this; }
        public BankAccountBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; }
        public BankAccountBuilder balance(Double balance) { this.balance = balance; return this; }
        public BankAccountBuilder currency(String currency) { this.currency = currency; return this; }
        public BankAccountBuilder type(AccountType type) { this.type = type; return this; }
        public BankAccountBuilder customer(Customer customer) { this.customer = customer; return this; }
        public BankAccount build() { return new BankAccount(id, createdAt, balance, currency, type, customer); }
    }
}

