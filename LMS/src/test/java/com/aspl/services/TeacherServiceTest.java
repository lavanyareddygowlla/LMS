package com.aspl.services;

import com.aspl.entities.Klass;
import com.aspl.entities.Student;
import com.aspl.entities.Teacher;
import com.aspl.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    private Teacher teacher;
    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Before
    public void setUp() throws Exception {
        teacher = new Teacher("Chyld",Gender.MALE,34);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTeacher() {
        Teacher result = this.teacherService.create(teacher);
        assertEquals(4,result.getId());
    }

    @Test(expected=javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateTeacherBadParameter() {
        teacher.setName(null);
        Teacher result = this.teacherService.create(teacher);
        assertNull(result.getName());
    }


    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher t=this.teacherService.create(teacher);
        Teacher res = this.teacherService.findTeacherById(1);
        assertNotNull(res);
    }

    @Test
    public void shouldNotFindStudentByIdBadId() throws Exception {
        teacher = this.teacherService.findTeacherById(5);
        assertNull(teacher);
    }

    @Test
    public void shouldFindAllMaleTeachers() throws Exception {
        Teacher t=this.teacherService.create(teacher);
        List<Teacher> aList=new ArrayList<Teacher>();
        aList= (List<Teacher>) this.teacherService.findAllTeachersByGender(Gender.MALE);
        assertEquals(2,aList.size());
    }

    @Test
    public void shouldFindAllFemaleTeachers() throws Exception {
        Teacher t=this.teacherService.create(teacher);
        List<Teacher> aList=new ArrayList<Teacher>();
        aList= (List<Teacher>) this.teacherService.findAllTeachersByGender(Gender.FEMALE);
        assertEquals(2,aList.size());
    }

    @Test
    public void shouldFindByAge() {
        Teacher t = this.teacherService.create(teacher);
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers = (List<Teacher>) this.teacherService.findTeachersByAgeGreaterThan(20);
        assertEquals(4,teachers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findTeacherById(2).getKlasses();
        assertEquals(2, klasses.size());
    }

    @Test
    @Transactional
    public void shouldFindNoKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findTeacherById(3).getKlasses();
        assertEquals(0, klasses.size());
    }

}