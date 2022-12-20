package com.chisoroscode.mongoapplication.service;

import com.chisoroscode.mongoapplication.domain.Address;
import com.chisoroscode.mongoapplication.domain.Student;
import com.chisoroscode.mongoapplication.domain.enums.Gender;
import com.chisoroscode.mongoapplication.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        studentRepository.findStudentByEmail(studentRequest.getEmail()).ifPresentOrElse(
                student -> {
                 throw new IllegalStateException("Student already exist with email "+ studentRequest.getEmail());
                },()->{
                    Student createdStudent=Student.builder()
                            .email(studentRequest.getEmail())
                            .gender(studentRequest.getGender())
                            .firstName(studentRequest.getFirstName())
                            .created(studentRequest.getCreated())
                            .lastName(studentRequest.getLastName())
                            .totalSpentInBooks(studentRequest.getTotalSpentInBooks())
                            .address(studentRequest.getAddress())
                            .build();
                    studentRepository.save(createdStudent);
                }
        );
        return studentRepository.findStudentByEmail(studentRequest.getEmail()).get();
    }

    @Override
    public List<Student> findStudents() {

        return studentRepository.findAll();
    }

    private void checkIntenetConnection(String url) throws Exception {
    }
}
