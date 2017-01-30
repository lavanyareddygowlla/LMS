package com.aspl;

import com.aspl.services.KlassServiceTest;
import com.aspl.services.StudentServiceTest;
import com.aspl.services.TeacherServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		StudentServiceTest.class,
		KlassServiceTest.class,
		TeacherServiceTest.class
})

public class LmsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
