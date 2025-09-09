package com.nader.studentmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Length(min = 2, max = 50)
    private String name;
    @Column
    @Email(message = "Email should be valid")
    private String email;
    @Column
    @Length(min = 2, max = 50)
    private String major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

}
