package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Account;
import com.chisoroscode.mongoapplication.repository.AccountRepository;
import com.chisoroscode.mongoapplication.service.exceptions.AccountNotFoundException;
import com.chisoroscode.mongoapplication.service.requests.AccountRequest;
import com.chisoroscode.mongoapplication.service.requests.TransferRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImpl accountService;
    @Test
    void createAccount() {


    }

    @Test
    void transferMoneyTest() {

        Account sourceAccount=new Account("Albert", BigDecimal.valueOf(1000));
        sourceAccount.setId("12");
        Account destinationAccount=new Account("Rudo", BigDecimal.valueOf(100));
        destinationAccount.setId("14");
        TransferRequest transferRequest=new TransferRequest();
        transferRequest.setAmount(BigDecimal.valueOf(300));
        transferRequest.setSource(sourceAccount.getName());
        transferRequest.setDestination(destinationAccount.getName());
        given(accountRepository.findAccountByName(sourceAccount.getName())).willReturn(Optional.of(sourceAccount));
        given(accountRepository.findAccountByName(destinationAccount.getName())).willReturn(Optional.of(destinationAccount));
        accountService.transferMoney(transferRequest);
        sourceAccount.setAmount(BigDecimal.valueOf(700));
        destinationAccount.setAmount(BigDecimal.valueOf(400));
        verify(accountRepository).save(sourceAccount);
        verify(accountRepository).save(destinationAccount);
    }

    @Test
    void RecordNotFoundExceptionFlow(){
        Account sourceAccount=new Account("Albert", BigDecimal.valueOf(1000));
        sourceAccount.setId("12");
        Account destinationAccount=new Account("Rudo", BigDecimal.valueOf(100));
        destinationAccount.setId("14");
        TransferRequest transferRequest=new TransferRequest();
        transferRequest.setAmount(BigDecimal.valueOf(300));
        transferRequest.setSource(sourceAccount.getName());
        transferRequest.setDestination(destinationAccount.getName());

        given(accountRepository.findAccountByName(sourceAccount.getName())).willReturn(Optional.empty());


        assertThrows(AccountNotFoundException.class,()->accountService.transferMoney(transferRequest));
        verify(accountRepository,never()).save(sourceAccount);
    }
}