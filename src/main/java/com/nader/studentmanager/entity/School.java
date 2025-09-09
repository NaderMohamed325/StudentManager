package com.nader.studentmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    @Setter
    private String name;


    @Column
    @Getter
    @Setter
    private String location;


    @Getter
    @Setter
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Student> students;


}
