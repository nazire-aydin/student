package uk.co.nazire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uk.co.nazire.model.Student;
import uk.co.nazire.service.StudentService;

@RestController
@RequestMapping("v1/student")
public class StudentController {

	private StudentService studentService;

	// create field constructor
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// Get Student List
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudentList() {
		return studentService.getStudentList();
	}

	// Get Sudent
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student getStudent(@PathVariable Long id) {
		return studentService.getId(id);
	}
}
