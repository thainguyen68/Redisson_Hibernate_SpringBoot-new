package com.example.demo_hibernate_redis.service;

import com.example.demo_hibernate_redis.model.Classes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassesService {
     List<Classes> getAllClasses();

    Classes getById(Long classesId);
}
