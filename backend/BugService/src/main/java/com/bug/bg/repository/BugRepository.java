package com.bug.bg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.bg.model.Bug;

public interface BugRepository extends JpaRepository<Bug, Long> {
	
	List<Bug> getBugsByUserId(Long userId);
	List<Bug> getBugsByProjectId(Long projectId);
}
