package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest studentRequest);
    List<Student> findStudents();
}
