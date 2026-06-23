package com.tatastrive.erp.JAM.Enterprises.Controller;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.Service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @PostMapping("/add")
    public Projects createProject(@RequestBody Projects projects) {
        return projectsService.saveProjects(projects);
    }

    @GetMapping("/getall")
    public List<Projects> getAllProjects() {
        return projectsService.getAllProjects();
    }

    @GetMapping("/get/{id}")
    public Projects getProjectById(@PathVariable Long id) {
        return projectsService.getProjectsById(id);
    }

    @PutMapping("/update/{id}")
    public Projects updateProject(@PathVariable Long id,
                                  @RequestBody Projects projects) {
        return projectsService.updateProject(id, projects);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectsService.deleteProjects(id);
        return "Project Deleted Successfully";
    }
}