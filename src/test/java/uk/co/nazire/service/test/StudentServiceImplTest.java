package uk.co.nazire.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import uk.co.nazire.exception.DataAlreadyExistException;
import uk.co.nazire.exception.DataNotFoundException;
import uk.co.nazire.model.Student;
import uk.co.nazire.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	public static final Student UNKNOWN_DATA = new Student("UNKNOWN", "UNKNOWN", 0 , "UNKNOWN");
	
	@Test
	public void findGetStudentList_shouldReturnData() {
		List<Student> expectedStudentList = StudentServiceImpl.STUDENT_DATA;
		
		//is there student list
		List<Student> studentList = studentService.getStudentList();
		assertThat(studentList).isNotNull();
		assertThat(studentList).isEqualTo(expectedStudentList);
	}
	@Test
	public void findStudent_shouldReturnData() {
		//is there any specific id
		Student expectedStudent = StudentServiceImpl.STUDENT_DATA.get(0);
		
		Student student = studentService.getStudent(expectedStudent.getId());
		
		assertThat(student).isNotNull();
		assertThat(student).isEqualTo(expectedStudent);
		
	}
	
	@Test(expected=DataNotFoundException.class)
	public void ifStudentNotFound_thenThrowException() {
		Student unknown = UNKNOWN_DATA;
		
		studentService.getStudent(unknown.getId());
		
		
	}
	@Test
	public void createStudent_shouldreturnCreateData() {
		
		//Arrange
		Student expectedStudent = new Student("esra","basoglu",19,"Science");
		
		 //act
		Student createStudent = studentService.createStudent(expectedStudent);
		
		//Assert
		assertThat(createStudent).isNotNull();
		assertThat(createStudent.getId()).isNotNull();
		assertThat(createStudent).isNotEqualTo(expectedStudent);
	}
	
	@Test(expected = DataAlreadyExistException.class)
	public void createStudent_whenStudentAlreadyExist_thtowException() {
		 //Arrange
		Student expectedStudent = studentService.STUDENT_DATA.get(0);
		
		//Act
		studentService.createStudent(expectedStudent);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
