package com.chisoroscode.mongoapplication.domain;

import com.chisoroscode.mongoapplication.service.requests.AccountRequest;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data

public class Account {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal amount;

    public Account(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }
}
