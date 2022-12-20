package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Account;
import com.chisoroscode.mongoapplication.repository.AccountRepository;
import com.chisoroscode.mongoapplication.service.exceptions.AccountNotFoundException;
import com.chisoroscode.mongoapplication.service.requests.AccountRequest;
import com.chisoroscode.mongoapplication.service.requests.TransferRequest;
import lombok.AllArgsConstructor;
import org.apache.catalina.webresources.FileResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Override
    public Account createAccount(AccountRequest accountRequest) {
        Account account=new Account(accountRequest.getName(),accountRequest.getAmount());
        accountRepository.findAccountByName(account.getName()).ifPresentOrElse(
                account1 -> {
                    throw new IllegalStateException("Account with same name already exist");
                },()-> accountRepository.save(account)

        );
        try {
            FileReader fileResource = new FileReader("");

        }catch (IOException fileNotFoundException){

        }
        return account;

    }

    @Override
    @Transactional
    public void transferMoney(TransferRequest transferRequest) {
        Account sourceAccount=accountRepository.findAccountByName(transferRequest.getSource()).orElseThrow(()-> new AccountNotFoundException("Account record not found"));
        Account destinationAccount=accountRepository.findAccountByName(transferRequest.getDestination()).orElseThrow(()-> new AccountNotFoundException("Account record not found"));
        if (sourceAccount.getAmount().compareTo(transferRequest.getAmount())>0){
            creditSourceAccount(transferRequest.getAmount(),destinationAccount);
            debitDestinationAccount(transferRequest.getAmount(),sourceAccount);
        }else {
            throw new IllegalStateException("Source account does not have enough money for the transaction");
        }
    }

    private void debitDestinationAccount(BigDecimal amount,Account sourceAccount) {
        sourceAccount.setAmount(sourceAccount.getAmount().subtract(amount));
        accountRepository.save(sourceAccount);
    }

    private void creditSourceAccount(BigDecimal amount,Account destinationAccount) {
        destinationAccount.setAmount(destinationAccount.getAmount().add(amount));
        accountRepository.save(destinationAccount);
    }
}
