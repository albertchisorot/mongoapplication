package com.chisoroscode.mongoapplication.service.requests;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TransferRequest {
    private String source;
    private String destination;
    private BigDecimal amount;
}
