package uk.co.nazire.controller.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import uk.co.nazire.StudentApplication;
import uk.co.nazire.exception.DataNotFoundException;
import uk.co.nazire.service.StudentService;
import uk.co.nazire.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
@AutoConfigureMockMvc
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	public void shouldReturnGetStudentListFromService() throws Exception {
		// Arrange
		when(studentService.getStudentList()).thenReturn(StudentServiceImpl.STUDENT_DATA);
		// Act
		this.mockMvc.perform(get("/v1/student")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("[0].id").value(StudentServiceImpl.STUDENT_DATA.get(0).getId()))
				.andExpect(jsonPath("[0].name").value(StudentServiceImpl.STUDENT_DATA.get(0).getName()))
				.andExpect(jsonPath("[0].surName").value(StudentServiceImpl.STUDENT_DATA.get(0).getSurName()))
				.andExpect(jsonPath("[0].age").value(StudentServiceImpl.STUDENT_DATA.get(0).getAge()))
				.andExpect(jsonPath("[0].courses").value(StudentServiceImpl.STUDENT_DATA.get(0).getCourses()));
		// Assert
		verify(studentService, times(1)).getStudentList();

	}

	@Test
	public void shouldReturnGetStudentSuccessfull() throws Exception {

		when(studentService.getId(2L)).thenReturn(StudentServiceImpl.STUDENT_DATA.get(1));

		this.mockMvc.perform(get("/v1/student/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("id").value(StudentServiceImpl.STUDENT_DATA.get(1).getId()))
				.andExpect(jsonPath("name").value(StudentServiceImpl.STUDENT_DATA.get(1).getName()))
				.andExpect(jsonPath("surName").value(StudentServiceImpl.STUDENT_DATA.get(1).getSurName()))
				.andExpect(jsonPath("age").value(StudentServiceImpl.STUDENT_DATA.get(1).getAge()))
				.andExpect(jsonPath("courses").value(StudentServiceImpl.STUDENT_DATA.get(1).getCourses()));

		verify(studentService, times(1)).getId(2L);
	}

	@Test
	public void shouldReturnDataNotFoundExceptionFromGetStudent() throws Exception {
		when(studentService.getId(100L)).thenThrow(DataNotFoundException.class);

		this.mockMvc.perform(get("/v1/student/100")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(jsonPath("details").value("uri=/v1/student/100"));

		verify(studentService, times(1)).getId(100L);

	}

}
