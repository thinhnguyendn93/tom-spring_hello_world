package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Integer age, String name) {
		// TODO Auto-generated method stub
		String SQL = "insert into Student (age,name) values (?,?)";
		jdbcTemplateObject.update(SQL, age,name);
		System.out.println("Created record name = "+name+" Age = "+age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Student where id=?";
		Student student = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Student where id =?";
		jdbcTemplateObject.update(SQL,id);
		System.out.println("Deleted record with ID = "+ id);
		return;
	}

	@Override
	public void update(Integer age, Integer id) {
		// TODO Auto-generated method stub
		String SQL = "update Student set age = ? where id =?";
		jdbcTemplateObject.update(SQL,id,age);
		System.out.println("Updated record with ID = "+id);
	}

}
