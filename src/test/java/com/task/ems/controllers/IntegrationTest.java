package com.task.ems.controllers;

import com.task.ems.controller.TimesheetController;
import com.task.ems.model.Employee;
import com.task.ems.controller.EmployeeController;
import com.task.ems.model.Timesheet;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController empController;

    @Test
    public void testEmpCreateReadDelete() {
        List<Employee> employees = empController.findAllEmployees();
        int size = employees.size();
        Employee emp = new Employee("Random", "7354239231", "Sales",
                "rand@ps.com", "White House, Washington, USA ", 'A');
        Employee empResult = empController.saveEmployee(emp);
        employees = empController.findAllEmployees();

        Assertions.assertThat(employees).last().hasFieldOrPropertyWithValue("empName","Random");
        Assertions.assertThat(empController.findAllEmployees().size() == ++size);
        empController.removeEmployee(empResult.getEmpId());
    }

    @Autowired
    TimesheetController timeController;

    @Test
    public void testTimeCreateReadDelete() {
        List<Timesheet> timesheets = timeController.findAllTimesheets();
        int size = timesheets.size();
        Timesheet time = new Timesheet(40, "26/12/2000",
                "Training", "PA-3");
        Timesheet timeResult = timeController.saveTimesheet(time);
        timesheets = timeController.findAllTimesheets();

        Assertions.assertThat(timesheets).last().hasFieldOrPropertyWithValue("timeTask","Training");
        Assertions.assertThat(timeController.findAllTimesheets().size() == ++size);
        timeController.removeTimesheet(timeResult.getTimesheetId());
    }
}
