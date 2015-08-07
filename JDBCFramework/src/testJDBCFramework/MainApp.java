package testJDBCFramework;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import testJDBCFramework.StudentJDBCTemplate;
public class MainApp {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println("--------Record creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Tom", 21);
		studentJDBCTemplate.create("Huck", 12);
		
		System.out.println("-------Listing record------");
		List<Student> students = studentJDBCTemplate.listStudent();
		for(Student record:students)
		{
			System.out.println("ID : " + record.getId());
			System.out.println("Name : "+ record.getName());
			System.out.println("Age : "+ record.getAge());
		}
		
		System.out.println("-------Updating record-------");
		studentJDBCTemplate.update(1, 22);
		
		System.out.println("--------Listing record---------");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.println("ID :" + student.getId());
		System.out.println("Name :" + student.getName());
		System.out.println("Age :" + student.getAge());
	}
}
