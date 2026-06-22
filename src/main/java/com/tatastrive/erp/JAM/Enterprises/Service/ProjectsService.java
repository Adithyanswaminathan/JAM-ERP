package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.dto.ProjectsDto;

import java.util.List;

public interface ProjectsService {

    ProjectsDto saveProjects(Projects projects);

    List<ProjectsDto> getAllProjects();

    ProjectsDto getProjectsById(Long id);

    ProjectsDto updateProjects(Long id, Projects projects);

    void deleteProjects(Long id);


}
