package com.seleniumexpress.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;

@Service("studentDAOHelper")
public class StudentDAOHelper {
	
	@Autowired
	private StudentDAOImpl studentDAO;
	
	public void setUpStudentTable(){
		
		Student newStudent1 = new Student();
		newStudent1.setRollNo(001);
		newStudent1.setName("Sandra");
		newStudent1.setAddress("Chengdu");
		
		Student newStudent2 = new Student();
		newStudent2.setRollNo(002);
		newStudent2.setName("Peter");
		newStudent2.setAddress("Austrailia");
		
		
		Student newStudent3 = new Student();
		newStudent3.setRollNo(003);
		newStudent3.setName("Abigail");
		newStudent3.setAddress("UK");
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(newStudent1);
		studentList.add(newStudent2);
		studentList.add(newStudent3);
		
		
		studentDAO.batchInsert(studentList);
		
	}

}
