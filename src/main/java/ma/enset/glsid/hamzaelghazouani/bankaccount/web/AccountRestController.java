package ma.enset.glsid.hamzaelghazouani.bankaccount.web;

import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountRequestDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.dtos.BankAccountResponseDTO;
import ma.enset.glsid.hamzaelghazouani.bankaccount.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.bankaccount.repositories.BankAccountRepository;
import ma.enset.glsid.hamzaelghazouani.bankaccount.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final AccountService accountService;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.updateAccount(id, requestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}

