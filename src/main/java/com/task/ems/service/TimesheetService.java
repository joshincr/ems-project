package com.task.ems.service;

import com.task.ems.model.Employee;
import com.task.ems.model.Timesheet;

import java.util.List;

public interface TimesheetService {
    List<Timesheet> retrieveAllTimesheets();

    // Read By Id
    Timesheet getTimesheetById(int timesheetId);

    // Create
    void createTimesheet(Timesheet employee);

    // Update
    void updateTimesheet(Timesheet employee);

    // Delete
    void deleteTimesheet(int timesheetId);
}
