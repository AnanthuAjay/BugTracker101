package com.assignments.see.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assignment")
public class Assignment {
	
	@Id
	@Column(name="id")
    private Long id;
	@Column(name="courseId")
    private Long courseId;
	@Column(name="title")
    private String title;
	@Column(name="description")
    private String description;
	@Column(name="dueDate")
    private Date dueDate;
	@Column(name="completedDate")
    private Date completedDate;
	@ElementCollection
	@Column(name="attachments")
    private List<String> attachments;
	@ElementCollection
	@Column(name="submissions")
    private List<String> submissions;
	@ElementCollection
	@Column(name="feedbacks")
    private List<String> feedbacks;
	@Column(name="grade")
    private String grade;
    
	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assignment(Long id, Long courseId, String title, String description, Date dueDate, Date completedDate,
			List<String> attachments, List<String> submissions, List<String> feedbacks, String grade) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.completedDate = completedDate;
		this.attachments = attachments;
		this.submissions = submissions;
		this.feedbacks = feedbacks;
		this.grade = grade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	public List<String> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	public List<String> getSubmissions() {
		return submissions;
	}
	public void setSubmissions(List<String> submissions) {
		this.submissions = submissions;
	}
	public List<String> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<String> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
    
    
}
