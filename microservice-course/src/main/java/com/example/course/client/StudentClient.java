package com.example.course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "msvc-student", path = "/api/student")
public interface StudentClient {

    @GetMapping("/{id}")
    public StudentRecord findById (@PathVariable Long id);

    @GetMapping("/all/{idCourse}")
    public List<StudentRecord> findAllStudentsByCourseId (@PathVariable Long idCourse);
}
