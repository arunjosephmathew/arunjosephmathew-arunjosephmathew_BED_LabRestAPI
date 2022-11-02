package com.greatlearning.debateRegistration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.debateRegistration.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findStudentRegistrationByName(String name);

}
