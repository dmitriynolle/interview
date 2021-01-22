package ru.interviev.lesson7.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
}
