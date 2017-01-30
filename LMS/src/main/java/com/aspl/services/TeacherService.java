package com.aspl.services;

import com.aspl.entities.Teacher;
import com.aspl.enums.Gender;
import com.aspl.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private ITeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(int i) {
        return this.teacherRepository.findOne(i);
    }

    public Iterable<Teacher> findAllTeachersByGender(Gender male) {
        return this.teacherRepository.findByGender(male);
    }

    public Iterable<Teacher> findTeachersByAgeGreaterThan(int i) {
        return this.teacherRepository.findByAgeGreaterThan(i);
    }

}
