package com.jpahibernate.example.school_management_DB.service;

// here we write the logics and implement it in the controller
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

    //to get all students
    public List<Student> getAllStudents(){
       List<Student> AllStudents = studentrepository.findAll();
       return AllStudents;
    }

    //get student by the id
    public  Student getById(int studentId){
        //here findbyid will give optional value so we are using .get()  to get the student details
       Student student = studentrepository.findById(studentId).get();
       return student;
    }

    //delete the student by student id  .. it will not return anything
    public  String deletebystudentid(int studentId){
        studentrepository.deleteById(studentId);
        return "student with id "+studentId+" got deleted";
    }

     //let us update the student details
    public  String updateStudent(int studentId, Student newStudentrequest){
              //it will find the id
        // if id is there it will update it
        // else no need to update
        //this getById we already written so we will use this only to get student details
        Student student = getById(studentId);
        if(student != null){
            studentrepository.save(newStudentrequest);
            return "student get updated with the id"+studentId+" ";
        }else{
            return "id not found";
        }
    }

    //update student using patch method
    public  String updateUsingPath(int studentId, String gender){
        Student student = getById(studentId);
        if(student != null){
            student.setGender(gender);
            studentrepository.save(student);
            return "student get updated with the id"+studentId+" ";
        }else{
            return "id not found";
        }
    }

}
