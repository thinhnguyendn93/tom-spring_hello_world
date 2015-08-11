package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setAge(rs.getInt("age"));
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		return student;
	}

}
