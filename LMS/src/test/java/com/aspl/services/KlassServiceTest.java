package com.aspl.services;


import com.aspl.entities.Klass;
import com.aspl.entities.Teacher;
import com.aspl.enums.Department;
import com.aspl.repositories.IKlassRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    private KlassService klassService;
    private TeacherService teacherService;


    Klass klass=new Klass();

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    @Before
    public void setUp() throws Exception {
        Teacher teacher = this.teacherService.findTeacherById(1);
        klass.setName("classname");
        klass.setCredits(2);
        klass.setFee(100000);
        klass.setDepartment(Department.ENGINEERING);
        klass.setSemester(new Date());
        klass.setTeacher(teacher);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldFindClassById() {

        Klass after = this.klassService.create(klass);
        Klass result = this.klassService.findKlassById(after.getId());
        assertEquals(4,result.getId());
    }

    @Test
    public void shouldNotFindClassById() {

        Klass after = this.klassService.create(klass);
        Klass result = this.klassService.findKlassById(after.getId());
        assertNotEquals(6,result.getId());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassByName() throws Exception {
        Klass after = this.klassService.create(klass);
        Klass klass = this.klassService.findByName("classname");
        assertEquals(4, klass.getId());
    }

    @Test
    @Transactional
    public void shouldNotFindOneKlassByBadName() throws Exception {
        Klass after = this.klassService.create(klass);
        Klass klass = this.klassService.findByName("classname1");
        assertNull(klass);
    }

    @Test
    @Transactional
    public void shouldFindTheTeacherFromKlass() throws Exception {
        Klass klass = this.klassService.findByName("Physics 101");
        assertEquals("lavanya", klass.getTeacher().getName());
    }

}