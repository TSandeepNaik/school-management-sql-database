package com.jpahibernate.example.school_management_DB.service;


//service class contain all business logics

import com.jpahibernate.example.school_management_DB.model.Student;
import com.jpahibernate.example.school_management_DB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // it means it contain business logics

public class StudentService {

    @Autowired    //we created inbuilt object using autowired for studentrepository interface which contain all the method
   private StudentRepository studentrepository;

    public  String saveStudent(Student student){
         studentrepository.save(student);
        return "student saved successfully";
    }

    //to save a list of all students
    public  String saveStudents(List<Student> studentList){
        studentrepository.saveAll(studentList);
        return "students saved successfully";
    }
}
