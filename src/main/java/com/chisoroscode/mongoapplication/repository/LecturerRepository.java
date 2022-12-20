package com.chisoroscode.mongoapplication.repository;

import com.chisoroscode.mongoapplication.domain.Lecturer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LecturerRepository extends MongoRepository<Lecturer,String> {

    boolean existsByContactDetailsEmail(String email);

}
