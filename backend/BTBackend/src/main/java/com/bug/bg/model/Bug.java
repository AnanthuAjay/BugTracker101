package com.bug.bg.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bug {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bugId;

  private String bugname;
  private String description;
  private String status;
  private Long userId;
  private String userName;

  private Date createdAt;
  private String assignedTo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "projectId", referencedColumnName = "projectId")
  private Project project;

  // Constructors, getters, and setters

  public Bug() {
    super();
  }

  public Bug(Long bugId, String bugname, String description, String status, Long userId, String userName,
             Date createdAt, String assignedTo, Project project) {
    super();
    this.bugId = bugId;
    this.bugname = bugname;
    this.description = description;
    this.status = status;
    this.userId = userId;
    this.userName = userName;
    this.createdAt = createdAt;
    this.assignedTo = assignedTo;
    this.project = project;
  }

  // Other getters and setters

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
