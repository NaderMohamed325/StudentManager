package com.nader.studentmanager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String location;


    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Student> students;


}
