package com.example.demo_hibernate_redis.repo;

import com.example.demo_hibernate_redis.model.Student;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRepositoryStudent extends JpaRepository<Student, Long> {
    @Override
    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    })
    List<Student> findAll();

    @Override
    @Transactional(value = TxType.REQUIRED)
    Student save(Student student);

    @Override
    @Modifying
    @Transactional
    @Query(value = "delete from student where id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long studentId);



}