package uk.co.nazire.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.nazire.model.Student;

public class StudentTest {

	@Test
	public void shouldDefineGetList() {
		Student student = new Student("beyza", "fidanel", 17, "math");

		assertNotNull(student.getId());

	}

	@Test
	public void dataShouldBeDifferent() {
		// to check hashcodes are equals
		Student student = new Student("beyza", "fidanel", 17, "math");
		Student student1 = new Student("azra", "solmaz", 20, "science");

		// if it is not equals code is correct
		assertNotEquals(student, student1);
	}

	@Test
	public void getterTest() {
		Student student = new Student("recep","solmaz",15,"PE");
		
		assertEquals("recep", student.getName());
		assertEquals("solmaz", student.getSurName());
		assertEquals(15, student.getAge());
		assertEquals("PE", student.getCourses());
	}

	@Test
	public void setterTest() {
		Student student = new Student();
		student.setName("Recep");
		student.setSurName("Solmaz");
		student.setAge(15);
		student.setCourses("Math");
		
		assertEquals("Recep", student.getName());
		assertEquals("Solmaz", student.getSurName());
		assertEquals(15, student.getAge());
		assertEquals("Math", student.getCourses());
	}
}
