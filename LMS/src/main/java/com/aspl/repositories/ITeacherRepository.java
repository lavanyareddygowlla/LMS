package com.aspl.repositories;

import com.aspl.entities.Teacher;
import com.aspl.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {

    public Teacher findByName(String name);
    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int age);
}
