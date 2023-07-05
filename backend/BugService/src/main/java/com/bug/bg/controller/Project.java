package com.bug.bg.controller;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Project {

    @Id
    private Long projectId;

    private String projectName;

    @ElementCollection
    private List<Long> bugIds;

    // Constructors, getters, and setters

    public Project() {
        super();
    }

    public Project(Long projectId, String projectName, List<Long> bugIds) {
        super();
        this.projectId = projectId;
        this.projectName = projectName;
        this.bugIds = bugIds;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Long> getBugIds() {
        return bugIds;
    }

    public void setBugIds(List<Long> bugIds) {
        this.bugIds = bugIds;
    }
}
