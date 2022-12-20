package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Account;
import com.chisoroscode.mongoapplication.service.requests.AccountRequest;
import com.chisoroscode.mongoapplication.service.requests.TransferRequest;

import java.math.BigDecimal;

public interface AccountService {
    Account createAccount(AccountRequest accountRequest);
    void transferMoney(TransferRequest transferRequest);
}
