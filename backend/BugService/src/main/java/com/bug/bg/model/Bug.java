package com.bug.bg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Bug {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bugId;
  
  private String bugname;
  private String[] description;
  private Long projectId;
  private String status;
  
  private Long userId;
  
  private Date createdAt;
  private String assignedTo;
public Bug() {
	super();
	// TODO Auto-generated constructor stub
}
public Bug(Long bugId, String bugname, String[] description, Long projectId, String status, Long userId,
		Date createdAt, String assignedTo) {
	super();
	this.bugId = bugId;
	this.bugname = bugname;
	this.description = description;
	this.projectId = projectId;
	this.status = status;
	this.userId = userId;
	this.createdAt = createdAt;
	this.assignedTo = assignedTo;
}
public Long getBugId() {
	return bugId;
}
public void setBugId(Long bugId) {
	this.bugId = bugId;
}
public String getBugname() {
	return bugname;
}
public void setBugname(String bugname) {
	this.bugname = bugname;
}
public String[] getDescription() {
	return description;
}
public void setDescription(String[] description) {
	this.description = description;
}
public Long getProjectId() {
	return projectId;
}
public void setProjectId(Long projectId) {
	this.projectId = projectId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Long getUserId() {
	return userId;
}
public void setCreatedByUserId(Long createdByUserId) {
	this.userId = createdByUserId;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public String getAssignedTo() {
	return assignedTo;
}
public void setAssignedTo(String assignedTo) {
	this.assignedTo = assignedTo;
}
  
  
  
}
