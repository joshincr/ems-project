package com.task.ems.controller;

import com.task.ems.model.Employee;
import com.task.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    // Create
    @PostMapping(value = "/employee")
    public Employee saveEmployee(@RequestBody Employee emp) {
        empService.createEmployee(emp);
        return emp;
    }

    // Read
    @GetMapping("/employee")
    public List<Employee> findAllEmployees() {
        return empService.retrieveAllEmployees();
    }

    // Read By Id
    @GetMapping("/getemployee/{empId}")
    public Employee findEmployeeById(@PathVariable int empId) {
        return empService.getEmployeeById(empId);
    }

    // Update
    @PutMapping("/employee")
    public Employee changeEmployee(@RequestBody Employee emp) {
        empService.updateEmployee(emp);
        return emp;
    }

    // Delete
    @DeleteMapping(value = "/employee/{empId}")
    public void removeEmployee(@PathVariable int empId) {
        empService.deleteEmployee(empId);
    }


    // Get Role
    @GetMapping("/getRole/{empId}")
    char getEmpRole(@PathVariable int empId) {
        return empService.getEmpRole(empId);
    }
}
