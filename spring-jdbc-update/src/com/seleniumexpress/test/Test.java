package com.seleniumexpress.test;

import java.util.List;
import java.util.Map;

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
		
		Student peter = new Student();
		peter.setAddress("Ekitti");
		peter.setRollNo(6);
		
		int updateStudent = studentDao.updateStudent(peter);
		
		System.out.println(updateStudent + " Roll updated");
		
		
		
		

	}

}
