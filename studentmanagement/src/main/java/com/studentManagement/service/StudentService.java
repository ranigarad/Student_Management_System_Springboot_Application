package com.studentManagement.service;

import java.util.List;

import com.studentManagement.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();

	Student save(Student s);

	Student getSudentById(Long id);
	
	Student update(Student s);

	void deleteStudentById(Long id);
	
	
	



	

	

	
	

}
