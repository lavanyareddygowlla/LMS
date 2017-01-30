package com.aspl.services;

import com.aspl.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateStudent() throws Exception {
        Student stud = new Student("abcd@gmail.com");
        Student after = this.studentService.createStudent(stud);
        assertEquals(2,after.getId());
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateStudentEmailNull() throws Exception {
        Student stud = new Student(null);
        Student student = this.studentService.createStudent(stud);
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student m = this.studentService.findStudentsByEmail("car@aol.com");
        assertNotNull(m);
    }

    @Test
    public void shouldNotFindMovieByIdBadTitle() throws Exception {
        Student m = this.studentService.findStudentsByEmail("Bad Email");
        assertNull(m);
    }


    @Test
    public void shouldFindStudentById() throws Exception {
        Student m = this.studentService.findStudentsById(1);
        assertNotNull(m);
    }


    @Test
    public void shouldNotFindStudentByIdBadId() throws Exception {
        Student m = this.studentService.findStudentsById(5);
        assertNull(m);
    }


}