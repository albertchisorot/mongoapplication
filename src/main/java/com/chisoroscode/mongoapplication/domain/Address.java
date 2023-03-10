package com.chisoroscode.mongoapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Address {
    private String country;
    private String city;
    private String postCode;
}
