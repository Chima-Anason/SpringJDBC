package com.seleniumexpress.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loaded....");
		
		StudentDAOImpl studentDAOImpl = context.getBean("studentDao", StudentDAOImpl.class);
		
		Student newStudent1 = new Student();
		newStudent1.setRollNo(005);
		newStudent1.setName("Sandra");
		newStudent1.setAddress("Chengdu");
		
		studentDAOImpl.insert(newStudent1);
		

	}

}
