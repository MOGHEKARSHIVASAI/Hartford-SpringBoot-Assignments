package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Employee;
import org.hartford.mappingdemo.entity.Project;
import org.hartford.mappingdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/{employeeId}/assign-project/{projectId}")
    public Employee assignProjectToEmployee(@PathVariable Long employeeId, @PathVariable Long projectId) {
        return employeeService.assignProjectToEmployee(employeeId, projectId);
    }

    @GetMapping("/{employeeId}/projects")
    public List<Project> getEmployeeProjects(@PathVariable Long employeeId) {
        return employeeService.getProjectsByEmployee(employeeId);
    }
}

