package com.task.ems.controllers;


import com.task.ems.controller.EmployeeController;
import com.task.ems.controller.TimesheetController;
import com.task.ems.model.Employee;
import com.task.ems.model.Timesheet;
import com.task.ems.service.EmployeeService;
import com.task.ems.service.TimesheetService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest({EmployeeController.class, TimesheetController.class})
public class StandaloneControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  EmployeeService empService;

  @Test
  public void testEmpCreateReadDelete() throws Exception {
    Employee emp = new Employee("Random", "7354239231", "Sales",
            "rand@ps.com", "White House, Washington, USA ", 'A');
    List<Employee> employees = Arrays.asList(emp);
    Mockito.when(empService.retrieveAllEmployees()).thenReturn(employees);

    mockMvc.perform(get("/employee"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].empName", Matchers.is("Random")));
  }

  @MockBean
  TimesheetService timeService;

  @Test
  public void testTimeCreateReadDelete() throws Exception {
    Timesheet time = new Timesheet(40, "26/12/2000",
            "Training", "PA-3");
    List<Timesheet> timesheets = Arrays.asList(time);
    Mockito.when(timeService.retrieveAllTimesheets()).thenReturn(timesheets);

    mockMvc.perform(get("/timesheet"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", Matchers.hasSize(1)))
            .andExpect(jsonPath("$[0].timeTask", Matchers.is("Training")));
  }

}
