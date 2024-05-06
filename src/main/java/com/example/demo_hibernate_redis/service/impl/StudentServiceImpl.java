package com.example.demo_hibernate_redis.service.impl;

import com.example.demo_hibernate_redis.controller.ResourceNotFoundException;
import com.example.demo_hibernate_redis.model.Student;
import com.example.demo_hibernate_redis.repo.IRepositoryStudent;
import com.example.demo_hibernate_redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final IRepositoryStudent repositoryStudent;

    @Autowired
    public StudentServiceImpl(IRepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    @Override
    public Student addStudent(Student student) {
       Student students = repositoryStudent.save(student);
        return repositoryStudent.findById(students.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + students.getId()));
    }

    @Override
    public List<Student> getAllStudents() {
        return repositoryStudent.findAll();
    }

    @Override
    public Student getById(Long studentId) {
        return repositoryStudent.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
    }

    @Override
    public void updateById(Long studentId, Student student) {
        Student studentS = repositoryStudent.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        studentS.setName(student.getName());
        studentS.setClasses(student.getClasses());
        repositoryStudent.save(studentS);
    }

    @Override
    public void deleteEmployee(Long studentId) {
       Student student = repositoryStudent.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
       repositoryStudent.deleteById(student.getId());
    }
    
}
