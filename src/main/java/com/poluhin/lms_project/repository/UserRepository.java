package com.poluhin.lms_project.repository;

import com.poluhin.lms_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}