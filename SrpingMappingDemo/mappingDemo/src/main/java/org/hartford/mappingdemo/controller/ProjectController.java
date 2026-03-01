package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Employee;
import org.hartford.mappingdemo.entity.Project;
import org.hartford.mappingdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PostMapping("/{projectId}/assign-employee/{employeeId}")
    public Project assignEmployeeToProject(@PathVariable Long projectId, @PathVariable Long employeeId) {
        return projectService.assignEmployeeToProject(projectId, employeeId);
    }

    @GetMapping("/{projectId}/employees")
    public List<Employee> getProjectEmployees(@PathVariable Long projectId) {
        return projectService.getEmployeesByProject(projectId);
    }
}

