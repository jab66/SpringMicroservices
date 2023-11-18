package com.example.course.service;

import com.example.course.client.CoursesByStudentRecord;
import com.example.course.client.StudentClient;
import com.example.course.client.StudentRecord;
import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public CoursesByStudentRecord getCoursesByStudent
            (List<StudentRecord> listCourses, Course course){
        return new CoursesByStudentRecord(course.getName(), listCourses) ;
    }
}
