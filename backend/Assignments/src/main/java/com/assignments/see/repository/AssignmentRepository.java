package com.assignments.see.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignments.see.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
