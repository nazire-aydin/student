package uk.co.nazire.service;

import java.util.List;

import uk.co.nazire.model.Student;
import uk.co.nazire.model.StudentEditInput;

public interface StudentService {

	List<Student> getStudentList();
	
	Student getStudent(Long id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Long id, Student student);
	
	Student editStudent(Long id, StudentEditInput input);
	
	void deleteStudent(Long id);
	
	}
