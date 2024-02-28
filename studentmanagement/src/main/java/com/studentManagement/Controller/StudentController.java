package com.studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentManagement.entity.Student;
import com.studentManagement.service.StudentService;


@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService service;    

//	public StudentController(StudentService service) {
//		super();
//		this.service = service;
//	}
//	
	
	
	@GetMapping("/")
	public String Student() {
		return "home";
}
	@GetMapping("/Student_Register")
	public String StudentRegister() {
		return "StudentRegister";
	}
	@GetMapping("/Student_List")
	public ModelAndView getAllStudent() {
		List<Student>list=service.getAllStudent();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("StudentList");
//		m.addObject("Student",list);
		return new ModelAndView("StudentList","Student", list);
	}
	
	@PostMapping("/save")
	public String addStudent(@ModelAttribute Student s) {
		service.save(s);
		return "redirect:/Student_List";		
	}
	
	@RequestMapping("/editStudent/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Student s = service.getSudentById(id);
		model.addAttribute("student",s);
		return "editStudent";
	}
	
	
	// handler method to handle delete student request
	
	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/Student_List";
	}
	
	
	
	
}
