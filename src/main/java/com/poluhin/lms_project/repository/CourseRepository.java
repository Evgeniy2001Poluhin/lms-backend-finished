package com.poluhin.lms_project.repository;

import com.poluhin.lms_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}