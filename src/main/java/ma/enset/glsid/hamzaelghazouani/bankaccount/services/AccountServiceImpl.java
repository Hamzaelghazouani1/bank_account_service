package ma.enset.glsid.hamzaelghazouani.bankaccount.services;

import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountRequestDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountResponseDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.bankaccount.mappers.AccountMapper;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository bankAccountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO dto) {
        BankAccount bankAccount = accountMapper.fromRequestDTO(dto);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.toResponseDTO(savedAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO dto) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
        
        if (dto.getBalance() != null) {
            bankAccount.setBalance(dto.getBalance());
        }
        if (dto.getCurrency() != null) {
            bankAccount.setCurrency(dto.getCurrency());
        }
        if (dto.getType() != null) {
            bankAccount.setType(dto.getType());
        }
        
        BankAccount updatedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.toResponseDTO(updatedAccount);
    }
}

