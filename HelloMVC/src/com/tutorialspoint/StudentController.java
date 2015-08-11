package com.tutorialspoint;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student()
	{
		return new ModelAndView("student","command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("SpringWeb")Student student,ModelMap model)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate jdbcTemp = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		
		ModelAndView modelAndView = new ModelAndView("result");
		

		Student student1 = new Student();
		student1 = jdbcTemp.getStudent(1);
		List<Student> listStudent = new ArrayList<>();
		listStudent = jdbcTemp.listStudent();
		System.out.println(listStudent.size());
		if(listStudent != null)
		{
			for(Student s:listStudent)
			{
				System.out.println("Student " + s.getName());
			}
		}
		if(student1 != null)
		{
			System.out.println("Got student name: " + student1.getName());
			System.out.println("Age " + student1.getAge());
		}
		System.out.println(listStudent.size());

		modelAndView.addObject("students", listStudent);

		return modelAndView;
	}
}
