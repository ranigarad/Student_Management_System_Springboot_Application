package com.studentManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentManagement.entity.Student;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository sRepo;       
	
	public StudentServiceImpl(StudentRepository sRepo) {
		super();
		this.sRepo = sRepo;
	}


	@Override
	public List<Student> getAllStudent() {
		return sRepo.findAll();
	}

	@Override
	public Student save(Student s) {
		return sRepo.save(s);
	}

	@Override
	public Student getSudentById(Long id) {
		return sRepo.findById(id).get();
	}

	@Override
	public Student update(Student s) {
		return sRepo.save(s);
	}

	@Override
	public void deleteStudentById(Long id) {
		sRepo.deleteById(id);
		
	}

}
