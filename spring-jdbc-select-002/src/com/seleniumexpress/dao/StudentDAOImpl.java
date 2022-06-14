package com.seleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.rowmapper.StudentRowMapper;

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


	@Override
	public void batchInsert(List<Student> students) {
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		ArrayList<Object[]> sqlArgObjects = new ArrayList<>();
		
		for(Student tempStudent : students) {
			
			Object[] sudentData ={tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getAddress()};
			
			sqlArgObjects.add(sudentData);
		}
		
		jdbcTemplate.batchUpdate(sql, sqlArgObjects);
		
		
		System.out.println("Batch insertion Completed !!!");
		
	}


	@Override
	public List<Student> findAllStudent() {
		
		String sql = "SELECT * FROM STUDENT";
		
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return studentList;
	}
	
	
	

}
