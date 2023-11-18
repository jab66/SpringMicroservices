package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent (@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student findById (@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAllStudents () {
        return studentService.findAll();
    }

    @GetMapping("/all/{idCourse}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAllStudentsByCourseId (@PathVariable Long idCourse) {
        return studentService.findAllStudentsByCourseId(idCourse);
    }

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/app")
    public String getAppName (){
        return appName;
    }
}
