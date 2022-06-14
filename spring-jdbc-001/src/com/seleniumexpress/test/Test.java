package com.seleniumexpress.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seleniumexpress.dao.StudentDAOImpl;
import com.seleniumexpress.service.StudentDAOHelper;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("application context loaded....");
		
//		StudentDAOImpl studentDAOImpl = context.getBean("studentDao", StudentDAOImpl.class);
		
		
		
//		boolean isDeleted = studentDAOImpl.deleteRecordByRollNo(004);
//		if(isDeleted) {
//			System.out.println("the roll no got deleted");
//		}
		
		
//		studentDAOImpl.deleteRecordByStudentNameOrStudentAddress("eva", "denmark");
		
//		studentDAOImpl.cleanUp();
		
		
		StudentDAOHelper studentDAOHelper = context.getBean("studentDAOHelper", StudentDAOHelper.class);
		studentDAOHelper.setUpStudentTable();

	}

}
