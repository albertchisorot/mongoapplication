package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Address;
import com.chisoroscode.mongoapplication.domain.enums.Gender;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;
}
