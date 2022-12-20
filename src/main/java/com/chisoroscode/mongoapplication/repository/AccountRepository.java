package com.chisoroscode.mongoapplication.repository;

import com.chisoroscode.mongoapplication.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account,String> {

    Optional<Account> findAccountByName(String name);
}
