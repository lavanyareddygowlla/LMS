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
    Iterable<Teacher> findAllTeachersByGender(Gender male);


    String sql1 = "select * from teachers where age > :age ";
    @Query(value = sql1, nativeQuery = true)
    Iterable<Teacher> findTeachersByAgeGreaterThan(@Param("age") int age);
}
