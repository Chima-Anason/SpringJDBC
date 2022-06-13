package com.seleniumexpress.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.seleniumexpress.api.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

	@Override
	public void insert(Student student) {
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};
		
		int noOfRollInserted = jdbcTemplate.update(sql,arg);
		
		
		System.out.println("No of roll inserted "+ noOfRollInserted);

	}
	
	
	public DataSource getDataSource(){
		
		String url = "jdbc:mysql://127.0.0.1:3306/School";
		String username = "root";
		String password = "rootuser";
		
		DataSource dataSource = new DriverManagerDataSource(url, username, password);
		
		
		return dataSource;
	}

}
