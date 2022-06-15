package com.seleniumexpress.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {

		//abuja {james}
		//sokoto {peter}
		
		Map<String, List<String>> studentTable = new HashMap<>();

		while (rs.next()) {
			String studentName = rs.getString("STUDENT_NAME");
			String studentAddress = rs.getString("STUDENT_ADDRESS");

			List<String> studentsNameList = studentTable.get(studentAddress); //{james}

			if (studentsNameList == null) {

				ArrayList<String> newStudentList = new ArrayList<>();
				newStudentList.add(studentName);

				studentTable.put(studentAddress, newStudentList);
				
				
			}else {
				studentsNameList.add(studentName);
			}

		}

		return studentTable;
	}

}
