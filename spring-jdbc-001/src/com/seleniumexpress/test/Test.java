package com.seleniumexpress.test;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAO;
import com.seleniumexpress.dao.StudentDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		Student newStudent1 = new Student();
		newStudent1.setRollNo(001);
		newStudent1.setName("Chima");
		newStudent1.setAddress("Abuja");
		
		StudentDAO studentDAO = new StudentDAOImpl();
		studentDAO.insert(newStudent1);

	}

}
