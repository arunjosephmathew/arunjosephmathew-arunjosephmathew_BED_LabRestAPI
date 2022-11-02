package com.greatlearning.debateRegistration.service;

import java.util.List;

import com.greatlearning.debateRegistration.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(long studentId);

	public boolean save(Student student);

	public boolean deleteById(long studentId);

}
