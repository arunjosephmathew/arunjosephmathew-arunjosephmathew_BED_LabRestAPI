package com.greatlearning.debateRegistration.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.debateRegistration.entity.Student;
import com.greatlearning.debateRegistration.service.StudentService;

@Controller
@RequestMapping("/registration")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/registrations")
	public String studentRegistrations(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("Registrations", students);
		return "registrations";
	}

	@PostMapping("/register")
	public String registerStudent(Student student) {
		Student newStudent = null;
		if (student.getStudentId() == 0) {
			newStudent = new Student(student.getName(), student.getDepartment(), student.getCountry());

		} else {
			newStudent = studentService.findById(student.getStudentId());
			newStudent.setName(student.getName());
			newStudent.setDepartment(student.getDepartment());
			newStudent.setCountry(student.getCountry());
		}

		return studentService.save(newStudent) ? "redirect:/registration/registrations"
				: "redirect:/registration/message?message=Failed to save student details";
	}

	@RequestMapping("/registration-form")
	public String showRegistrationForm(Model model) {
		Student student = new Student();
		System.out.println(student.toString());
		model.addAttribute("student", student);
		return "registration-form";
	}

	@RequestMapping("/update-registration-form")
	public String showRegistrationForm(@RequestParam("studentId") long studentId, Model model) {
		Student student = studentService.findById(studentId);
		model.addAttribute("student", student);
		return "registration-form";
	}

	@RequestMapping("/delete-registration")
	public String deleteStudentRegistration(@RequestParam("studentId") long studentId) {

		return studentService.deleteById(studentId) ? "redirect:/registration/registrations"
				: "redirect:/registration/message?message=Failed to delete student registration with id - " + studentId;
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", You are not authorised to do this action");
		} else {
			model.addObject("msg", "You are not authorised to do this action");
		}

		model.setViewName("403");
		return model;
	}

	@RequestMapping("/message")
	public String showMessagePage(@RequestParam("message") String message, Model model) {
		model.addAttribute("message", message);
		return "message";
	}
}