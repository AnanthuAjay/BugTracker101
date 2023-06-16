package com.project.pro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pro.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Long> getBugListsByProjectId(Long id);
}
