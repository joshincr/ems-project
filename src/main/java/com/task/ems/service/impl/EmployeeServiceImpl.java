package com.task.ems.service.impl;

import com.task.ems.model.Employee;
import com.task.ems.repository.EmployeeRepository;
import com.task.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository empRepository;

    @Override
    public List<Employee> retrieveAllEmployees() {
        Iterable<Employee> employee = empRepository.findAll();
        return (List<Employee>)employee;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        Optional<Employee> emp = empRepository.findById(empId);
        return emp.get();
    }

    @Override
    public void createEmployee(Employee emp) {
        empRepository.save(emp);
    }

    @Override
    public void updateEmployee(Employee emp) {
        empRepository.save(emp);
    }

    @Override
    public void deleteEmployee(int empId) {
        empRepository.deleteById(empId);
        return;
    }

    @Override
    public char getEmpRole(int empId) {
        Employee emp = empRepository.findById(empId).get();
        return emp.getEmpRole();
    }

}
