package com.seleniumexpress.test;

import java.util.ArrayList;
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
		peter.setAddress("Shanghai333");
		peter.setRollNo(6);
		
		Student james = new Student();
		james.setAddress("Beijing333");
		james.setRollNo(2);
		
		Student sam = new Student();
		sam.setAddress("Hohhot333");
		sam.setRollNo(7);
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(peter);
		studentList.add(james);
		studentList.add(sam);
		
		//Starting Batch update
		int updatedRowCount = studentDao.updateStudents(studentList);
		System.out.println(updatedRowCount + " No of rows got affected....");
		
		//int updateStudent = studentDao.updateStudent(peter);
		
		
		
		
		

	}

}
