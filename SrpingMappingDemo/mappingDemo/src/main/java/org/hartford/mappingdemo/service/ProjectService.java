package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Employee;
import org.hartford.mappingdemo.entity.Project;
import org.hartford.mappingdemo.repository.EmployeeRepository;
import org.hartford.mappingdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    public Project findById(Long id) {
        return projectRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid project id"));
    }

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public Project assignEmployeeToProject(Long projectId, Long employeeId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Invalid project id"));
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee id"));
        project.getEmployees().add(employee);
        return projectRepo.save(project);
    }

    public List<Employee> getEmployeesByProject(Long projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Invalid project id"));
        return project.getEmployees();
    }
}

