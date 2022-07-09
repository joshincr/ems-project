package com.task.ems.service.impl;
import com.task.ems.model.Timesheet;
import com.task.ems.repository.TimesheetRepository;
import com.task.ems.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;

@Service
public class TimesheetServiceImpl implements TimesheetService {
    @Autowired
    TimesheetRepository timeRepository;

    public List<Timesheet> retrieveAllTimesheets() {
        Iterable<Timesheet> time = timeRepository.findAll();
        return (List<Timesheet>)time;
    }

    @Override
    public Timesheet getTimesheetById(int timesheetId) {
        Optional<Timesheet> time = timeRepository.findById(timesheetId);
        return time.get();
    }

    @Override
    public void createTimesheet(Timesheet time) {
        timeRepository.save(time);
    }

    @Override
    public void updateTimesheet(Timesheet time) {
        timeRepository.save(time);
    }

    @Override
    public void deleteTimesheet(int timesheetId) {
        timeRepository.deleteById(timesheetId);
        return;
    }

}
