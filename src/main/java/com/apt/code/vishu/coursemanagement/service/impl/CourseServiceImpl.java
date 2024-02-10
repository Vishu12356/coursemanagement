package com.apt.code.vishu.coursemanagement.service.impl;

import com.apt.code.vishu.coursemanagement.entity.Course;
import com.apt.code.vishu.coursemanagement.entity.CourseDtoStudent;
import com.apt.code.vishu.coursemanagement.repository.CourseRepository;
import com.apt.code.vishu.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * @param course
     * @return Course
     */
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    /**
     * @param id
     * @param role
     * @return Course
     */
    @Override
    public Course getCourse(Long id, String role) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found."));
        if (role.equals("student")) {
            CourseDtoStudent.builder().build();
            return course;
        } else if (role.equals("course_developer") || role.equals("content_developer")) {

            return course;
        } else {
            return course; // Handle invalid role
        }
    }

    /**
     * @param id
     * @param courseDetails
     * @return
     */
    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setChapters(courseDetails.getChapters());
        course.setName(courseDetails.getName());
        course.setNoOfClasses(course.getNoOfClasses());
        course.setSubject(course.getSubject());
        course.setCourseType(course.getCourseType());
        course.setLearnMode(course.getLearnMode());
        return courseRepository.save(course);
    }
}
