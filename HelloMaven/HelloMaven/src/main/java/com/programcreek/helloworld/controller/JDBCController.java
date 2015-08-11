package com.programcreek.helloworld.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JDBCController {
	
	@RequestMapping("/students")
	public ModelAndView students()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JDBCTemplate jd = (JDBCTemplate) context.getBean("JDBCTemplate");
		List<Student> listStudent = jd.listStudent();
		ModelAndView md = new ModelAndView("students");
		md.addObject("students", listStudent);
		return md;
		
	}
	
	@RequestMapping(value = "/addnewstudent")
	public ModelAndView addNewStudent()
	{
		return new ModelAndView("addStudent","student",new Student());
	}
	
	@RequestMapping(value = "/addingStudent", method = RequestMethod.POST)
	public String addingNewStudent(@ModelAttribute("student") Student student,ModelMap model)
	{
		model.addAttribute("name",student.getName());
		model.addAttribute("age",student.getAge());
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JDBCTemplate jd = (JDBCTemplate) context.getBean("JDBCTemplate");
		jd.create(student.getAge(), student.getName());
		return "redirect:/students";
	}
	
	@RequestMapping(value ="/deleteStudent",method = RequestMethod.GET)
	public String deleteStudent(@RequestParam(value= "id") int id)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JDBCTemplate jd = (JDBCTemplate) context.getBean("JDBCTemplate");
		jd.delete(id);
		return "redirect:/students";
	}
	
	@RequestMapping(value = "/updating", method = RequestMethod.GET)
	public ModelAndView updating(@RequestParam(value= "id") int id,@RequestParam(value= "name") String name,@RequestParam(value= "age") int age)
	{
		Student student1 = new Student();
		student1.setAge(age);
		student1.setId(id);
		student1.setName(name);
		return new ModelAndView("updateStudent","student",student1);
	}
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JDBCTemplate jd = (JDBCTemplate) context.getBean("JDBCTemplate");
		jd.update(student.getAge(), student.getId());
		return "redirect:/students";
	}
	
	
}
