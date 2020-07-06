package uk.co.nazire.model.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.nazire.model.Student;

public class StudentTest {
	
	@Test
	public void ShouldDefineGetList() {
		Student student = new Student("beyza","fidanel",17,"math");
		
		assertNotNull(student.getId());
		
	}

}
