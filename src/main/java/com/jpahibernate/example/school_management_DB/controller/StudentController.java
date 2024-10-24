package com.jpahibernate.example.school_management_DB.controller;

import com.jpahibernate.example.school_management_DB.model.Student;
import com.jpahibernate.example.school_management_DB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {
    //controller <--> service <--> repository

    //to use save function will create object for service class where we written save function
    @Autowired
    StudentService studentservice;


@PostMapping("/saving")
    public  String addingstudent( @RequestBody Student student){
      String response = studentservice.saveStudent(student);
      return response;
    }

    @PostMapping("/savingmany")
    public  String addingstudents( @RequestBody List<Student> studentList){
        String response = studentservice.saveStudents(studentList);
        return response;
    }


}
