package com.seleniumexpress.dao;

import java.util.List;
import java.util.Map;

import com.seleniumexpress.api.Student;

public interface StudentDAO {

	void insert(Student student);
	
	void batchInsert(List<Student> students); //Batch Insert
	
	boolean deleteRecordByRollNo(int rollNo);
	
	int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
	
	List<Student> findAllStudent();
	
	Student findStudentByRollNo(int roll_No);
	
	List<Student> findStudentByName(String name);
	
	Map<String,List<String>> groupStudentByAddress(); //Address -> List<Student> Table
	
	int updateStudent(Student student);
	
	int updateStudents(List<Student> studentList); //Batch update
}
