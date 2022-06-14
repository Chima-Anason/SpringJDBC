package com.seleniumexpress.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;
import com.seleniumexpress.service.StudentDAOHelper;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loaded....");
		

		StudentDAOHelper helper = context.getBean("studentDAOHelper", StudentDAOHelper.class);
		
		//SETTING UP THE TABLE DATA
		helper.setUpStudentTable();
		
		
		//call findAllStudent() >> FETCHING THE DATA FROM THE TABLE
		StudentDAOImpl studentDao = context.getBean("studentDao", StudentDAOImpl.class);
		List<Student> studentList = studentDao.findAllStudent();
		
		helper.printStudents(studentList);
		
		
		//CLEAN UP THE TABLE DATA
		studentDao.cleanUp();
		

	}

}
