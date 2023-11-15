package com.example.redisspring.controllers;

import com.example.redisspring.domain.Student;
import com.example.redisspring.domain.StudentDTO;
import com.example.redisspring.repositories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO dto) {
        Student student = new Student(UUID.randomUUID().toString(), dto.name(), dto.gender(), dto.grade());
        repository.save(student);
        return ResponseEntity.ok(student);
    }
}