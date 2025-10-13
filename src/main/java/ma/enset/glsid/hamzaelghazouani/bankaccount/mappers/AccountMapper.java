package ma.enset.glsid.hamzaelghazouani.bankaccount.mappers;

import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountRequestDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountResponseDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccount fromRequestDTO(BankAccountRequestDTO dto) {
        BankAccount account = new BankAccount();
        BeanUtils.copyProperties(dto, account);
        return account;
    }

    public BankAccountResponseDTO toResponseDTO(BankAccount account) {
        BankAccountResponseDTO dto = new BankAccountResponseDTO();
        BeanUtils.copyProperties(account, dto);
        return dto;
    }
}

