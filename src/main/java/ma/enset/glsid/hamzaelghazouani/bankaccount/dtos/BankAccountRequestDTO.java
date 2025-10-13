package ma.enset.glsid.hamzaelghazouani.bankaccount.dtos;

import ma.enset.glsid.hamzaelghazouani.bankaccount.enums.AccountType;

public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;

    public BankAccountRequestDTO() {
    }

    public BankAccountRequestDTO(Double balance, String currency, AccountType type) {
        this.balance = balance;
        this.currency = currency;
        this.type = type;
    }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public AccountType getType() { return type; }
    public void setType(AccountType type) { this.type = type; }

    public static BankAccountRequestDTOBuilder builder() { return new BankAccountRequestDTOBuilder(); }

    public static class BankAccountRequestDTOBuilder {
        private Double balance;
        private String currency;
        private AccountType type;

        public BankAccountRequestDTOBuilder balance(Double balance) { this.balance = balance; return this; }
        public BankAccountRequestDTOBuilder currency(String currency) { this.currency = currency; return this; }
        public BankAccountRequestDTOBuilder type(AccountType type) { this.type = type; return this; }
        public BankAccountRequestDTO build() { return new BankAccountRequestDTO(balance, currency, type); }
    }
}

