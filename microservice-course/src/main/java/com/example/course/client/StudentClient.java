package com.example.course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student" , url = "localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/{id}")
    public StudentRecord getStudentByServiceStudent (@PathVariable Long id);

    @GetMapping("/all/{idCourse}")
    public List<StudentRecord> getCoursesByStudent (@PathVariable Long idCourse);
}
