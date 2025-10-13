package ma.enset.glsid.hamzaelghazouani.bankaccount.services;

import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountRequestDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO dto);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO dto);
}

