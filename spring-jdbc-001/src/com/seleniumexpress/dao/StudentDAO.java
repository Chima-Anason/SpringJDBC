package com.seleniumexpress.dao;

import com.seleniumexpress.api.Student;

public interface StudentDAO {

	void insert(Student student);
	
	boolean deleteRecordByRollNo(int rollNo);
	
	int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
}
