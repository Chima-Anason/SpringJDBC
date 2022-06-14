package com.seleniumexpress.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.api.Student;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void insert(Student student) {
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};
		
		int noOfRollInserted = jdbcTemplate.update(sql,arg);
		
		
		System.out.println("No of roll inserted "+ noOfRollInserted);

	}


	@Override
	public boolean deleteRecordByRollNo(int rollNo) {
		
		String sql = "DELETE FROM STUDENT WHERE ROLL_NO = ?";
		
		int noOfRowDeleted = jdbcTemplate.update(sql, rollNo);
		
		System.out.println("No of record deleted " + noOfRowDeleted);
		
		return noOfRowDeleted == 1;
	}


	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {
		
		String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";
		
		Object[] arg = {studentName, studentAddress};
		
		int noOfRowDeleted = jdbcTemplate.update(sql, arg);
		
		System.out.println("No of rows deleted are " + noOfRowDeleted);
		return noOfRowDeleted;
	}
	
	
	
	//delete all record in the student table
	public void cleanUp(){
		
		
		String sql = "TRUNCATE TABLE STUDENT";
		
		jdbcTemplate.execute(sql);
		
		System.out.println("Table cleaned up>>> ");
		
		
	}
	
	
	

}
