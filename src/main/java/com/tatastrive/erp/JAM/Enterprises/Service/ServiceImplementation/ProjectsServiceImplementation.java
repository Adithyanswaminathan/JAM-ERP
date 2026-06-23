package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.Repository.ProjectsRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.ProjectsService;
import com.tatastrive.erp.JAM.Enterprises.dto.ProjectsDto;
import com.tatastrive.erp.JAM.Enterprises.mapper.ProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImplementation implements ProjectsService {

    @Autowired
    private ProjectsMapper projectsMapper;
    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public ProjectsDto saveProjects(Projects projects) {
        Projects savedProjects = projectsRepository.save(projects);
        return projectsMapper.toDTO(savedProjects);
    }

    @Override
    public List<ProjectsDto> getAllProjects() {
        return projectsRepository.findAll()
                .stream()
                .map(projectsMapper::toDTO)
                .toList();
    }

    @Override
    public ProjectsDto getProjectsById(Long id) {
      Projects projects = projectsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset Not Found"));
        return projectsMapper.toDTO(projects);
    }

    @Override
    public ProjectsDto updateProjects(Long id, Projects projects) {

        Projects existingProject =
                projectsRepository.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found"));



            existingProject.setProjectName(projects.getProjectName());
            existingProject.setClientName(projects.getClientName());
            existingProject.setBudget(projects.getBudget());
            existingProject.setStartDate(projects.getStartDate());
            existingProject.setEndDate(projects.getEndDate());
            existingProject.setStatus(projects.getStatus());
            existingProject.setEmployees(projects.getEmployees());

        Projects updatedProjects = projectsRepository.save(existingProject);

        return projectsMapper.toDTO(updatedProjects);
    }

    @Override
    public void deleteProjects(Long id) {
        Projects projects = projectsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        projectsRepository.delete(projects);
    }


}
