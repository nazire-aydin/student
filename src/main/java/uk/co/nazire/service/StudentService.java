package uk.co.nazire.service;

import java.util.List;

import uk.co.nazire.model.Student;

public interface StudentService {
	List<Student> getStudentList();
	Student getId(Long id);

}
