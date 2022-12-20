package com.chisoroscode.mongoapplication.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Lecturer {
    private String id;
    private String name;
    private String surname;
    private List<String> modules;

    private ContactDetails contactDetails;

    public Lecturer(String name, String surname, List<String> modules,ContactDetails contactDetails) {
        this.name = name;
        this.surname = surname;
        this.modules = modules;
        this.contactDetails=contactDetails;
    }
}
