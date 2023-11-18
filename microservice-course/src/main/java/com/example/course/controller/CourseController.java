package com.example.course.controller;

import com.example.course.client.CoursesByStudentRecord;
import com.example.course.client.StudentClient;
import com.example.course.client.StudentRecord;
import com.example.course.entity.Course;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentClient studentClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse (@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Course findById (@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Course> findAllCourses () {
        return courseService.findAll();
    }

    //
    // metodos que llaman a otro microservicios ---------------------------------
    //
    @GetMapping("/student/{id}")
    public StudentRecord getStudentByServiceStudent(@PathVariable Long id){
        return studentClient.getStudentByServiceStudent(id);
    }

    @GetMapping("/courses/student/{idCourse}")
    public CoursesByStudentRecord getCoursesByStudent(@PathVariable Long idCourse){
        List<StudentRecord> listStudentRecord = studentClient.getCoursesByStudent(idCourse);
        Course course = courseService.findById(idCourse);
        return courseService.getCoursesByStudent(listStudentRecord, course);
    }
}
