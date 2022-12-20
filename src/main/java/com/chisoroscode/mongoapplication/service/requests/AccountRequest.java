package com.chisoroscode.mongoapplication.service.requests;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountRequest {
    private String name;
    private BigDecimal amount;
}
