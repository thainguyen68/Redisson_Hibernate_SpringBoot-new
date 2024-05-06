package com.example.demo_hibernate_redis.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;


@Entity
@ToString
@NoArgsConstructor
@Data
@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "STUDENT")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    Classes classes;

}
