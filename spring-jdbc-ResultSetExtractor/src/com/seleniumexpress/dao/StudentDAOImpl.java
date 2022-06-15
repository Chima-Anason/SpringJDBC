package com.seleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.resultsetextractor.StudentAddressResultSetExtractor;
import com.seleniumexpress.resultsetextractor.StudentResultSetExtractor;
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
		
		String sql = "SELECT * FROM STUDENT ";
		
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return studentList;
	}


	@Override
	public Student findStudentByRollNo(int roll_No) {
		
		String sql = "SELECT ROLL_NO as rollNo,"
				         + " STUDENT_NAME as name,"
				         + " STUDENT_ADDRESS as address "
				         + "FROM STUDENT WHERE ROLL_NO = ?";
		
		Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), roll_No);
		
		return student;
	}


	@Override
	public List<Student> findStudentByName(String name) {
		
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME = ?";
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentResultSetExtractor(),name);
		return studentList;
	}


	@Override
	public Map<String, List<String>> groupStudentByAddress() {
		
		String sql = "SELECT * FROM STUDENT";
		
		Map<String, List<String>> query = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());
		
		return query;
	}
	
	
	

}
