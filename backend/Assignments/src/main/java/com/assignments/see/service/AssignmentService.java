package com.assignments.see.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignments.see.model.Assignment;
import com.assignments.see.repository.AssignmentRepository;


@Service
public class AssignmentService {

	@Autowired
	AssignmentRepository assignmentRepository;
	
	public Assignment createAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		assignmentRepository.save(assignment);
		return assignment;
	}

	public Assignment getAssignmentById(Long id) {
		// TODO Auto-generated method stub
		Assignment assignment = assignmentRepository.findById(id).get();
		return assignment;
	}

	public Assignment updateAssignment(Long id, Assignment assignment) {
		// TODO Auto-generated method stub
		Assignment gotassignment = assignmentRepository.findById(id).get();
		gotassignment.setAttachments(assignment.getAttachments());
		gotassignment.setCompletedDate(assignment.getCompletedDate());
		gotassignment.setCourseId(assignment.getCourseId());
		gotassignment.setDescription(assignment.getDescription());
		gotassignment.setDueDate(assignment.getDueDate());
		gotassignment.setFeedbacks(assignment.getFeedbacks());
		gotassignment.setGrade(assignment.getGrade());
		gotassignment.setSubmissions(assignment.getSubmissions());
		gotassignment.setTitle(assignment.getTitle());
		assignmentRepository.save(gotassignment);
		return gotassignment;
	}

	public boolean deleteAssignment(Long id) {
		// TODO Auto-generated method stub
		if(assignmentRepository.findById(id).isPresent()) {
			assignmentRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

}
