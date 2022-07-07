package com.koria.api.service;

import java.util.List;

import com.koria.api.models.Student;

public interface StudentService {
	Student save(Student student);
	Student update(Student student);
	Student find(Long id);
	List<Student> findAll();
	void delete(Student student);

}
