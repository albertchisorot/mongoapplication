package com.chisoroscode.mongoapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDetails {

    private String phoneNumber;
    private String email;
}
