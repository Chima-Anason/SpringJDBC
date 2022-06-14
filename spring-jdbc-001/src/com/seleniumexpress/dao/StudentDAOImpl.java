package com.seleniumexpress.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.seleniumexpress.api.Student;

public class StudentDAOImpl implements StudentDAO {
	
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
	
	
	

}
