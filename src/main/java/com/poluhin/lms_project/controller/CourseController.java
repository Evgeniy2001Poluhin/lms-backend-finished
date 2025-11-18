package com.poluhin.lms_project.controller;

import com.poluhin.lms_project.entity.Course;
import com.poluhin.lms_project.entity.User;
import com.poluhin.lms_project.repository.CourseRepository;
import com.poluhin.lms_project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseController(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/{courseId}/enroll/{studentId}")
    public Course enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.getCourses().add(course);
        userRepository.save(student);

        return course;
    }
}