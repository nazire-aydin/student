package uk.co.nazire.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import uk.co.nazire.exception.DataNotFoundException;
import uk.co.nazire.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	public static final List<Student> STUDENT_DATA = new ArrayList<>(Arrays
			.asList(new Student("Beyza", "Fidanel", 17, "math,science"), new Student("Azra", "Solmaz", 20, "math")));

	@Override
	public List<Student> getStudentList() {
		return STUDENT_DATA;
	}

	@Override
	public Student getId(Long id) {
		return STUDENT_DATA.stream().filter(s -> s.getId().equals(id)).findAny()
				.orElseThrow(() -> new DataNotFoundException(id + "not found"));
	}

}
