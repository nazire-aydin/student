package uk.co.nazire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uk.co.nazire.model.Student;
import uk.co.nazire.model.StudentEditInput;
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

	//Get Student
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
	}
	
	//create studentList
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	//Update Student
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	// update editInputStudent
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student updateStudentEditInput(@PathVariable Long id, @RequestBody StudentEditInput input ) {
		return studentService.editStudent(id,input);
	}
}
