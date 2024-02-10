package com.kvscode.crudjpa.dataaccessobject;

import com.kvscode.crudjpa.entity.Student;
import java.util.*;

public interface StudentDAO {

    //Saving the data into the table 
    void save(Student theStudent);

    //Read the Data from the table using id 
    Student findById(Integer id);

    //Querying the full table 

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    //updating the student data
    void update(Student theStudent);

    //delting the student 
    void delete(int id);

}
