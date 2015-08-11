package com.programcreek.helloworld.controller;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource ds);
	public void create(Integer age,String name);
	public Student getStudent(Integer id);
	public List<Student> listStudent();
	public void delete(Integer id);
	public void update(Integer age, Integer id);
	
}
