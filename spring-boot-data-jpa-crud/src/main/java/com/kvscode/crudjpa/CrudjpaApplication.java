package com.kvscode.crudjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kvscode.crudjpa.dataaccessobject.StudentDAO;
import com.kvscode.crudjpa.entity.Student;
import java.util.*;

@SpringBootApplication
public class CrudjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjpaApplication.class, args);
	}

	//executes after beans are loaded 
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		//injecting the studentdao 
		//custom code 
		return runner -> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForSerchingByLastName(studentDAO);

			//updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}

	public void deleteStudent(StudentDAO studentDAO)
	{
		int studentId=2;
		System.out.println("Deleting the student id 2 : ");
		studentDAO.delete(studentId);

	}

	public void updateStudent(StudentDAO studentDAO)
	{
		//get the student based on id for which we wanna update
		
		int studId=4;
		Student mystudent=studentDAO.findById(studId);

		//set the fisrtName kvsai
		mystudent.setFisrtName("kvsai");
		//merge the deatils
		studentDAO.update(mystudent);
	
		//print the details

		System.out.println("Updated student is:" + mystudent);
	}

	public void queryForSerchingByLastName(StudentDAO studentDAO)
	{
		List<Student> theStudQuery=studentDAO.findByLastName("Manikanta");

		System.out.println("The list of students having last name = Manikanta");
		for(Student tmpStudent : theStudQuery)
		{
			System.out.println(tmpStudent+" ");
		}
	}

	public void queryForStudents(StudentDAO studentDAO)
	{
		//get the all the students 
		List<Student> allStudents=studentDAO.findAll();

		for(Student tmpStudent : allStudents)
		{
			System.out.println(tmpStudent);
		}
	}

	public void readStudent(StudentDAO studentDAO)
	{
		System.out.println("Create a new student object..");
		Student thestudent=new Student("Anshuman","Sing","anshuman@gmail.com");

		System.out.println("save Student....");
		studentDAO.save(thestudent);

		System.out.println(" Get the Student id :" + thestudent.getId());

		System.out.println("Get the student for the given id : ...");

		Student mystudent=studentDAO.findById(thestudent.getId());

		System.out.println("Found the student :"+ mystudent);
	}
	
	public void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating new student ...");
		Student tmpStudent=new Student("Ayyapa","Swamy","ayyapa@gmail.com");

		System.out.println("saving the Student deatils ....");

		studentDAO.save(tmpStudent);

		Student tmp0Student=new Student("Radha","Krishna","radhakrishna@gmail.com");

		System.out.println("saving the Student deatils ....");

		studentDAO.save(tmp0Student);
		Student tmp1Student=new Student("Kvs","Manikanta","kvsmanikanta@gmail.com");

		System.out.println("saving the Student deatils ....");

		studentDAO.save(tmp1Student);
		Student tmp2Student=new Student("Kvm","Sudhakar","sudhakar@gmail.com");

		System.out.println("saving the Student deatils ....");

		studentDAO.save(tmp2Student);
		Student tmp3Student=new Student("k","Sarvani","sarvani@gmail.com");

		System.out.println("saving the Student deatils ....");

		studentDAO.save(tmp3Student);
		
		System.out.println("Saved student generated ID :" + tmpStudent.getId()+" "+
															tmp0Student.getId()+" "+
															tmp1Student.getId()+" "+
															tmp2Student.getId()+" "+
															tmp3Student.getId());
	}
	
}
