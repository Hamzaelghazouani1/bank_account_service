package ma.enset.glsid.hamzaelghazouani.bankaccount.dtos;

import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;

import java.util.Date;

public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;

    public BankAccountResponseDTO() {
    }

    public BankAccountResponseDTO(String id, Date createdAt, Double balance, String currency, AccountType type) {
        this.id = id;
        this.createdAt = createdAt;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
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

    public static BankAccountResponseDTOBuilder builder() { return new BankAccountResponseDTOBuilder(); }

    public static class BankAccountResponseDTOBuilder {
        private String id;
        private Date createdAt;
        private Double balance;
        private String currency;
        private AccountType type;

        public BankAccountResponseDTOBuilder id(String id) { this.id = id; return this; }
        public BankAccountResponseDTOBuilder createdAt(Date createdAt) { this.createdAt = createdAt; return this; }
        public BankAccountResponseDTOBuilder balance(Double balance) { this.balance = balance; return this; }
        public BankAccountResponseDTOBuilder currency(String currency) { this.currency = currency; return this; }
        public BankAccountResponseDTOBuilder type(AccountType type) { this.type = type; return this; }
        public BankAccountResponseDTO build() { return new BankAccountResponseDTO(id, createdAt, balance, currency, type); }
    }
}

