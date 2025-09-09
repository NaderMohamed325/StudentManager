package com.nader.studentmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Column
    @Length(min = 2, max = 50)
    @Getter
    @Setter
    private String name;


    @Column
    @Email(message = "Email should be valid")
    @Getter
    @Setter
    private String email;


    @Column
    @Length(min = 2, max = 50)
    @Getter
    @Setter
    private String major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    @Getter
    @Setter
    private School school;


}
