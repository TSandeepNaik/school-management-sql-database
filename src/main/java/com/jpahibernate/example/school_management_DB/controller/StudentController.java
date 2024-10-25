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

    @GetMapping("/getAll")
     public List<Student> getall(){
     List<Student> getallstudents = studentservice.getAllStudents();
     return getallstudents;
     }

     //get the student details by student id
    @GetMapping("/getbyid/{studentid}")
    public  Student getByStudentId( @PathVariable("studentid") int studentId){
   Student student = studentservice.getById(studentId);
      return student;
    }

    //delete studentby id
    @DeleteMapping("/deleteByid/{studentid}")
    public String deleteById(@PathVariable("studentid")  int studentId){
           String response = studentservice.deletebystudentid(studentId);
           return response;

    }

    //let us update the student
    //PUT = To update the whole details like a object
    //PATCH = TO update specific field

    @PutMapping("/updating/{studentid}")
    public  String updateStudent(@PathVariable("studentid")  int studentId, @RequestBody Student newstudentrequest){
         String response = studentservice.updateStudent(studentId, newstudentrequest);
         return response;
    }

 //update student using patch function
    @PatchMapping("/updatepatch/{studentid}")
    public  String updateStudent( @PathVariable("studentid") int studentId, @RequestParam String gender){
         String response = studentservice.updateUsingPath(studentId,gender);
         return response;
    }

}
