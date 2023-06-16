package com.assignments.see.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Grade")
public class Grade {
	
	@Id
	@Column(name="gradeId")
    private Long gradeId;
	@Column(name="assignmentId")
    private Long assignmentId;
	@Column(name="studentId")
    private Long studentId;
	@Column(name="grade")
    private double grade;
	@Column(name="gradedDate")
    private Date gradedDate;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(Long gradeId, Long assignmentId, Long studentId, double grade, Date gradedDate) {
		super();
		this.gradeId = gradeId;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
		this.grade = grade;
		this.gradedDate = gradedDate;
	}
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Date getGradedDate() {
		return gradedDate;
	}
	public void setGradedDate(Date gradedDate) {
		this.gradedDate = gradedDate;
	}
    
    
}
