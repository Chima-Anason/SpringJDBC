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
		
		
		StudentDAOImpl studentDao = context.getBean("studentDao", StudentDAOImpl.class);
		
		System.out.println("Printing students where name is Obi>>>>>>");
		System.out.println("Using the ResultSetExtractor Approach........");
		List<Student> findStudentByName = studentDao.findStudentByName("Obi");
		helper.printStudents(findStudentByName);
		
		
		System.out.println("*****************************************************");
		System.out.println("Printing all the students from the Student table");
		System.out.println("Using the RowMapper Approach........");
		List<Student> studentList = studentDao.findAllStudent();
		helper.printStudents(studentList);
		
		

	}

}
