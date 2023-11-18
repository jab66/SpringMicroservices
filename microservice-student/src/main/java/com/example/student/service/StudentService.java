package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudentsByCourseId (Long id){
        return studentRepository.findAllStudentsByCourseId(id);
    }

}
