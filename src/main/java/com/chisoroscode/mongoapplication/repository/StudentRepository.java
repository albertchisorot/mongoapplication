package com.chisoroscode.mongoapplication.repository;

import com.chisoroscode.mongoapplication.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findStudentByEmail(String email);
    boolean existsByEmail(String email);

}
