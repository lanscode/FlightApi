package com.koria.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koria.api.models.Student;
import com.koria.api.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public Student update(Student student) {
		return repository.save(student);
	}

	@Override
	public Student find(Long id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		repository.delete(student);
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
