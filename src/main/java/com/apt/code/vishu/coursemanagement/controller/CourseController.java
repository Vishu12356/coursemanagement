package com.apt.code.vishu.coursemanagement.controller;

import com.apt.code.vishu.coursemanagement.entity.Course;
import com.apt.code.vishu.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse (@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @GetMapping("/get")
    public ResponseEntity<Course> getCourse (@RequestParam Long id, @RequestParam String role) {
        return ResponseEntity.ok(courseService.getCourse(id, role));
    }

    @PatchMapping("/update")
    public ResponseEntity<Course> updateCourse (@RequestParam Long id, @RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }
}
