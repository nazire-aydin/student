package uk.co.nazire.service.test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import uk.co.nazire.exception.DataAlreadyExistException;
import uk.co.nazire.exception.DataNotFoundException;
import uk.co.nazire.model.Student;
import uk.co.nazire.model.StudentEditInput;
import uk.co.nazire.service.StudentServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@InjectMocks
	private StudentServiceImpl studentService;

	public static final Student UNKNOWN_DATA = new Student("UNKNOWN", "UNKNOWN", 0, "UNKNOWN");

	@Test
	public void findGetStudentList_shouldReturnData() {
		List<Student> expectedStudentList = StudentServiceImpl.STUDENT_DATA;

		// is there student list
		List<Student> studentList = studentService.getStudentList();
		assertThat(studentList).isNotNull();
		assertThat(studentList).isEqualTo(expectedStudentList);
	}

	@Test
	public void findStudent_shouldReturnData() {
		// is there any specific id
		Student expectedStudent = StudentServiceImpl.STUDENT_DATA.get(0);

		Student student = studentService.getStudent(expectedStudent.getId());

		assertThat(student).isNotNull();
		assertThat(student).isEqualTo(expectedStudent);

	}

	@Test(expected = DataNotFoundException.class)
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
	public void createStudent_whenStudentAlreadyExist_throwException() {
		 //Arrange
		Student expectedStudent = StudentServiceImpl.STUDENT_DATA.get(0);
		
		//Act
		studentService.createStudent(expectedStudent);
	}
	
	@Test
	public void updateStudent_shouldReturnUpdateData() {
		//Arrange
		Student currentStudent = StudentServiceImpl.STUDENT_DATA.get(0);
		Student updateStudent = new Student("Cevdet", "Aydin", 10, "Football");
		
		//Act
		currentStudent = studentService.updateStudent(currentStudent.getId(), updateStudent);
		
		//Verify
		assertThat(currentStudent).isNotNull();
		assertEquals(currentStudent.getName(), updateStudent.getName());
		assertEquals(currentStudent.getSurName(), updateStudent.getSurName());
		assertEquals(currentStudent.getAge(), updateStudent.getAge());
		assertEquals(currentStudent.getCourses(), updateStudent.getCourses());
	}

	@Test(expected = DataNotFoundException.class)
	public void updateStudent_DataNotFoundException() {
		//Arrange
		Student updateStudent = new Student("Talat", "Aydin", 15, "Math");
		
		//Act
		studentService.updateStudent(34004L, updateStudent);
	}
	
	@Test 
	public void studentEditInput_shouldReturnStudentEditInput() {
		//Arrange
		Student currentStudent = StudentServiceImpl.STUDENT_DATA.get(0);
		StudentEditInput patchStudent = new StudentEditInput("Riza","Aydin");
		
		//Act
		currentStudent = studentService.editStudent(currentStudent.getId(), patchStudent);//talata sor neden eklemiyor
		
		//verify
		assertThat(currentStudent).isNotNull();
		assertEquals(currentStudent.getName(), patchStudent.getName());
		assertEquals(currentStudent.getSurName(), patchStudent.getSurName());
		
	}
	
	@Test(expected = DataNotFoundException.class)
	public void studentEditInput_DataNotFoundException() {
		//Arrange
		StudentEditInput editStudent =  new StudentEditInput("Riza" , "Aydin");
		
		//Act
		studentService.editStudent(20L, editStudent);
		
	}
	
	@Test
	public void deleteStudent_shouldReturnAnyData() {
		Student expectedStudent = StudentServiceImpl.STUDENT_DATA.get(0);
		
		studentService.deleteStudent(expectedStudent.getId());
		
		assertNotEquals(expectedStudent, StudentServiceImpl.STUDENT_DATA.get(0));
		
	}
	
	@Test(expected = DataNotFoundException.class)
	public void ifStudentNotFound_ThenThrowException() {
		
		Student unknown = UNKNOWN_DATA;
		//test if data not found that can throw exceptıon
		studentService.deleteStudent(unknown.getId());
		
	}
	
}