package com.example.demo_hibernate_redis.service;

import com.example.demo_hibernate_redis.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getById(Long studentId);

    void updateById(Long studentId, Student student);

    void deleteEmployee(Long studentId);
}
