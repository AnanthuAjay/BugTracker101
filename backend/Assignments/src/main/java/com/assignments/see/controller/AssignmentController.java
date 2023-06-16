package com.assignments.see.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignments.see.model.Assignment;
import com.assignments.see.model.Grade;
import com.assignments.see.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

	 private static final String GRADE_SERVICE_URL = "http://localhost:8084/api/grades";
	 private final RestTemplate restTemplate;

	 public AssignmentController(RestTemplate restTemplate) {
	     this.restTemplate = restTemplate;
	 }
	
	@Autowired
	AssignmentService assignmentService;
   
	@GetMapping("/{assignmentId}/grade")
    public ResponseEntity<Grade> getGradeForAssignment(@PathVariable Long assignmentId) {
        String gradeServiceUrl = GRADE_SERVICE_URL + "/" + assignmentId;
        ResponseEntity<Grade> response = restTemplate.getForEntity(gradeServiceUrl, Grade.class);
        // Handle the response as needed
        return response;
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment createdAssignment = assignmentService.createAssignment(assignment);
        return ResponseEntity.ok(createdAssignment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable("id") Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        if (assignment != null) {
            return ResponseEntity.ok(assignment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable("id") Long id, @RequestBody Assignment assignment) {
        Assignment updatedAssignment = assignmentService.updateAssignment(id, assignment);
        if (updatedAssignment != null) {
            return ResponseEntity.ok(updatedAssignment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable("id") Long id) {
        boolean deleted = assignmentService.deleteAssignment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Additional methods for handling assignment submissions, grading, and feedback

}
