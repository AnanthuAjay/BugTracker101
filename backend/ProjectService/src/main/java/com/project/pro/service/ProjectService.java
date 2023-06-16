package com.project.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pro.model.Project;
import com.project.pro.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	public Project getProjectById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}

	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	public Project updateProject(Long id, Project project) {
		// TODO Auto-generated method stub
		Project gotProject = projectRepository.findById(id).get();
		projectRepository.delete(gotProject);
		return projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	public List<Long> getBugListsByProjectId(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.getBugListsByProjectId(id);
	}

	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

}
