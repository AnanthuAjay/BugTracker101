package com.bug.bg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.bg.model.Bug;
import com.bug.bg.repository.BugRepository;

@Service
public class BugService {
	
	@Autowired
	BugRepository bugRepository;

	public Bug getBugById(Long id) {
		// TODO Auto-generated method stub
		return bugRepository.findById(id).get();
	}

	public Bug createBug(Bug bug) {
		// TODO Auto-generated method stub
		return bugRepository.save(bug);
	}

	public Bug updateBug(Long id,Bug updatedBug) {
		// TODO Auto-generated method stub
		Bug bug = bugRepository.findById(id).get();
		bugRepository.delete(bug);
		return bugRepository.save(updatedBug);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		bugRepository.deleteById(id);
	}

	public List<Bug> getBugsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return bugRepository.getBugsByUserId(userId);
	}

	public List<Bug> getBugsByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		return bugRepository.getBugsByProjectId(projectId);
	}

}
