package com.task.ems.controller;

import com.task.ems.model.Timesheet;
import com.task.ems.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class TimesheetController {
    @Autowired
    private TimesheetService timeService;

    // Create
    @PostMapping(value = "/timesheet")
    public Timesheet saveTimesheet(@RequestBody Timesheet time) {
        timeService.createTimesheet(time);
        return time;
    }

    // Read
    @GetMapping("/timesheet")
    public List<Timesheet> findAllTimesheets() {
        return timeService.retrieveAllTimesheets();
    }

    // Read By Id
    @GetMapping("/gettimesheet/{timesheetId}")
    public Timesheet findTimesheetById(@PathVariable int timesheetId) {
        return timeService.getTimesheetById(timesheetId);
    }

    // Update
    @PutMapping("/timesheet")
    public Timesheet changeTimesheet(@RequestBody Timesheet time) {
        timeService.updateTimesheet(time);
        return time;
    }

    // Delete
    @DeleteMapping(value = "/timesheet/{timesheetId}")
    public void removeTimesheet(@PathVariable int timesheetId) {
        timeService.deleteTimesheet(timesheetId);;
    }
}
