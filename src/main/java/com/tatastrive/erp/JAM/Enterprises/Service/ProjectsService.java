package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;

import java.util.List;

public interface ProjectsService {

    Projects saveProjects(Projects projects);

    List<Projects> getAllProjects();

    Projects getProjectsById(Long id);

    Projects updateProject(Long id, Projects projects);

    void deleteProjects(Long id);
}
