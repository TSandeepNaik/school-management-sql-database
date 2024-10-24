package com.jpahibernate.example.school_management_DB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //it refers that this is a model class or a entity class
@Data    // it will create the getter and setters internally
@NoArgsConstructor  //it will create the default constructor
@AllArgsConstructor   //it will create the parameterised constructor
@Table(name="student")  // it will create the table inside the database with the name student
//if we give Table annotation without giving the name it will take the class name and create the table

public class Student {

    @Id  // it will concider studentId as a primary key and it can not have duplicate values
    @Column(name="student_id")  // it will create a column in database by the name student_id
    private int studentId;

    @Column(name="name", nullable = false) // means this column cannot be null, if we give true then it can be null
    private String name;

    @Column(name="grade", nullable = false)
    private  String grade;

    @Column(name="dob", nullable = false)
    private String dob;

    @Column(name="gender", nullable = false)
    private String gender;

}
