package com.seleniumexpress.dao;

import java.util.List;

import com.seleniumexpress.api.Student;

public interface StudentDAO {

	void insert(Student student);
	
	void batchInsert(List<Student> students);
	
	boolean deleteRecordByRollNo(int rollNo);
	
	int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
	
	List<Student> findAllStudent();
}
