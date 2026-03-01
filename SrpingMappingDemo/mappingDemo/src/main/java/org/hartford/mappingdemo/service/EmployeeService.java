package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Employee;
import org.hartford.mappingdemo.entity.Project;
import org.hartford.mappingdemo.repository.EmployeeRepository;
import org.hartford.mappingdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ProjectRepository projectRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid employee id"));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee assignProjectToEmployee(Long employeeId, Long projectId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee id"));
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Invalid project id"));
        employee.getProjects().add(project);
        return employeeRepo.save(employee);
    }

    public List<Project> getProjectsByEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Invalid employee id"));
        return employee.getProjects();
    }
}

