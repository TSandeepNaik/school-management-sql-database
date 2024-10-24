package com.jpahibernate.example.school_management_DB.repository;
//in Repository we create interface not class

import com.jpahibernate.example.school_management_DB.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   //it is data layer it will perform database activity
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //inside the jparepository we pass name of the model class, datatype of the primary key
    //it contains all the methods like save delete etc .
    //we simply create the object of it and use it wherever need

}
