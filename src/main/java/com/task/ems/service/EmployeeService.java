package com.task.ems.service;
import com.task.ems.model.Employee;

import java.util.List;

public interface EmployeeService  {
    // Read
    List<Employee> retrieveAllEmployees();

    // Read By Id
    Employee getEmployeeById(int empId);

    // Create
    void createEmployee(Employee employee);

    // Update
    void updateEmployee(Employee employee);

    // Delete
    void deleteEmployee(int empId);

    // Get Role
    char getEmpRole(int empId);
}
