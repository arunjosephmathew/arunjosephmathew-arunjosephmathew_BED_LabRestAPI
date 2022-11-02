package com.greatlearning.debateRegistration.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.debateRegistration.entity.Student;
import com.greatlearning.debateRegistration.repository.RoleRepository;
import com.greatlearning.debateRegistration.repository.StudentRepository;
import com.greatlearning.debateRegistration.repository.UserRepository;
import com.greatlearning.debateRegistration.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long studentId) {
		Student student = null;
		Optional<Student> optionalResult = studentRepository.findById(studentId);
		if (optionalResult.isPresent()) {
			student = optionalResult.get();
		} else {
			throw new RuntimeException("No registration found for student with id - " + studentId);
		}
		return student;
	}

	@Override
	public boolean save(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent.getName().equals(student.getName());
	}

	@Override
	public boolean deleteById(long studentId) {
		try {
			studentRepository.deleteById(studentId);

			Optional<Student> student = studentRepository.findById(studentId);
			if (!student.isPresent()) {
				return true;
			}
		} catch (java.util.NoSuchElementException ex) {
			// For completion of deleting
			return true;
		} catch (Exception ex) {
			// For error while recording
			System.out.println("Error occurred while deleting the record - " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		return false;
	}
}
