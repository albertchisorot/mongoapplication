package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.ContactDetails;
import lombok.Data;

import java.util.List;
@Data
public class LecturerRequest {

    private String name;
    private String surname;
    private List<String> modules;

    private ContactDetails contactDetails;
}
