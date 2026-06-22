package com.tatastrive.erp.JAM.Enterprises.Controller;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.Response.ApiResponse;
import com.tatastrive.erp.JAM.Enterprises.Service.ProjectsService;
import com.tatastrive.erp.JAM.Enterprises.dto.ProjectsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> saveProjects(@RequestBody Projects projects) {
        ProjectsDto savedProjects = projectsService.saveProjects(projects);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Project Created Successfully", savedProjects));
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllProjects() {
        try {
            List<ProjectsDto> projects= projectsService.getAllProjects();
            return ResponseEntity.ok(new ApiResponse("Sucess",projects));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getProjectById(@PathVariable Long id) {
        try {
            ProjectsDto projects = projectsService.getProjectsById(id);

            return ResponseEntity.ok(
                    new ApiResponse("Project Retrieved Successfully", projects)
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProjects(
            @PathVariable Long id,
            @RequestBody Projects projects) {

        try {
            ProjectsDto updatedProjects = projectsService.updateProjects(id, projects);

            return ResponseEntity.ok(
                    new ApiResponse("Project Updated Successfully", updatedProjects)
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProjects(@PathVariable Long id) {
        try {
            projectsService.deleteProjects(id);
            return ResponseEntity.ok(
                    new ApiResponse("Project Deleted Successfully", null)
            );

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
}


