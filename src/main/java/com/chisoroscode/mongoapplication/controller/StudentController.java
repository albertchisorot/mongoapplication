package com.chisoroscode.mongoapplication.controller;

import com.chisoroscode.mongoapplication.domain.Student;
import com.chisoroscode.mongoapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> findStudents(){
        return studentService.findStudents();
    }
}
