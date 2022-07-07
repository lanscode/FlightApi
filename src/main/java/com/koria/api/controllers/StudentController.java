package com.koria.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koria.api.models.Student;
import com.koria.api.service.StudentService;
import com.koria.api.util.EmailUtil;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private EmailUtil emailUtil;
	@Value("${spring.mail.username}")
	private String toAdr;
	
	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String getStudentCreationForm() {
		return "student/create";
		
	}
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public String createStudent(@ModelAttribute("student") Student student,ModelMap modelMap) {
		Student savedStudent = service.save(student);
		String msg = "Student saved with id "+savedStudent.getId();
		modelMap.addAttribute("msg", msg);
		System.out.println(student.toString());
		//Send mail to inform the student creation
		emailUtil.sendEmail(toAdr+"@gmail.com", "Student "+student.getName()+" Saved successfully");
		//Student creation mail has been send
		return "student/create";	
	}
	@RequestMapping(method = RequestMethod.GET,value = "/index")
  public String index(ModelMap modelMap) {	
	List<Student> students = service.findAll();
	modelMap.addAttribute("students", students);
	return "student/index";
  }
	@RequestMapping(method = RequestMethod.GET, value = "/updateForm")
  public String update(@RequestParam("id") Long id,ModelMap modelMap) {
		Student student = service.find(id);
		modelMap.addAttribute("student", student);
		//modelMap.addAttribute(student.getGender(), "selected");
	  return "student/edit";	
}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updated")
	public String update(@ModelAttribute("student") Student student,ModelMap modelMap) {
		Student savedStudent = service.update(student);
		System.out.println(savedStudent.toString());
		List<Student> students = service.findAll();
		modelMap.addAttribute("students", students);
		return "student/index";
	}
}
