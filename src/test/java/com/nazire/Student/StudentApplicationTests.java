package com.nazire.Student;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uk.co.nazire.controller.StudentController;


@RunWith(SpringRunner.class)
@SpringBootTest
class StudentApplicationTests {

	@Autowired
	private StudentController controller;

	@Test
	void contextLoads() {
        assertThat(controller).isNotNull();
	}

}
