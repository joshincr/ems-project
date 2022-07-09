package com.task.ems.repository;

import com.task.ems.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public List<Employee> findByEmpRole(int empId);
 }