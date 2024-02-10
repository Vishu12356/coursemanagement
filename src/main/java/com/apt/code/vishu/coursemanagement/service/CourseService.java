package com.apt.code.vishu.coursemanagement.service;

import com.apt.code.vishu.coursemanagement.entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Course createCourse (Course course);
    Course getCourse (Long id, String role);
    Course updateCourse (Long id, Course course);
}
