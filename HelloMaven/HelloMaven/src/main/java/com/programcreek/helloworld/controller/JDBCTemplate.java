package com.programcreek.helloworld.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JDBCTemplate implements StudentDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
		
	}

	public void create(Integer age, String name) {
		// TODO Auto-generated method stub
		String SQL = "insert into Student (age,name) values (?,?)";
		jdbcTemplateObject.update(SQL, age,name);
		System.out.println("Created record name = "+name+" Age = "+age);
		return;
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Student where id=?";
		Student student = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new StudentMapper());
		return student;
	}

	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Student where id =?";
		jdbcTemplateObject.update(SQL,id);
		System.out.println("Deleted record with ID = "+ id);
		return;
	}

	public void update(Integer age, Integer id) {
		// TODO Auto-generated method stub
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated record with ID = "+id);
	}

}
