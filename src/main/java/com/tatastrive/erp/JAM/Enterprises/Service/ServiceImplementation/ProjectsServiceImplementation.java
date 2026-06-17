package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.Repository.ProjectsRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImplementation implements ProjectsService {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public Projects saveProjects(Projects projects) {
        return projectsRepository.save(projects);
    }

    @Override
    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }

    @Override
    public Projects getProjectsById(Long id) {
        return projectsRepository.findById(id).orElse(null);
    }

    @Override
    public Projects updateProject(Long id, Projects projects) {

        Projects existingProject =
                projectsRepository.findById(id).orElse(null);

        if (existingProject != null) {

            existingProject.setProjectName(projects.getProjectName());
            existingProject.setClientName(projects.getClientName());
            existingProject.setBudget(projects.getBudget());
            existingProject.setStartDate(projects.getStartDate());
            existingProject.setEndDate(projects.getEndDate());
            existingProject.setStatus(projects.getStatus());
            existingProject.setEmployees(projects.getEmployees());

            return projectsRepository.save(existingProject);
        }

        return null;
    }

    @Override
    public void deleteProjects(Long id) {
        projectsRepository.deleteById(id);
    }
}
