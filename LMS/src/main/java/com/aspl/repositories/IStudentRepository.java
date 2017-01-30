package com.aspl.repositories;

import com.aspl.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Integer>{

    public Student findByEmail(String email);
}
