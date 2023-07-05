package com.bug.bg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.bg.model.Bug;
import com.bug.bg.service.BugService;

@RestController
@RequestMapping("/bugs")
@CrossOrigin("*")
public class BugController {

  @Autowired
  private BugService bugService;

  @GetMapping("/{id}")
  public Bug getBugById(@PathVariable("id") Long id) {
    return bugService.getBugById(id);
  }
  @GetMapping
  public List<Bug> getAllBugs() {
    // Retrieve bugs associated with the specified project from the Project Microservice or the database
    // Return the list of bugs associated with the project
	  return bugService.getAllBugs();
  }

  @PostMapping
  public Bug createBug(@RequestBody Bug bug) {
    return bugService.createBug(bug);
  }

  @PutMapping("/{id}")
  public Bug updateBug(@PathVariable("id") Long id, @RequestBody Bug updatedBug) {
    return bugService.updateBug(id,updatedBug);
  }

  @DeleteMapping("/{id}")
  public void deleteBug(@PathVariable("id") Long id) {
    bugService.deleteById(id);
  }

  @GetMapping("/user/{userId}")
  public List<Bug> getBugsByUserId(@PathVariable("userId") Long userId) {
    // Retrieve bugs assigned to the specified user from the User Microservice or the database
    // Return the list of bugs assigned to the user
	  return bugService.getBugsByUserId(userId);
  }

//  @GetMapping("/project/{projectId}")
//  public List<Bug> getBugsByProjectId(@PathVariable("projectId") Long projectId) {
//    // Retrieve bugs associated with the specified project from the Project Microservice or the database
//    // Return the list of bugs associated with the project
//	  return bugService.getBugsByProjectId(projectId);
//  }
  
  

}
