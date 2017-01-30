package com.aspl.services;


import com.aspl.entities.Student;
import com.aspl.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudentRepository studentRepository;


    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student)
    {
       return this.studentRepository.save(student);
    }

    public Student findStudentsById(int id){
        return this.studentRepository.findOne(id);
    }

    public Student findStudentsByEmail(String email){
        return this.studentRepository.findByEmail(email);
    }


}
