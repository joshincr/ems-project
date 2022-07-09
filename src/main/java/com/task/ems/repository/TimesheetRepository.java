package com.task.ems.repository;

import com.task.ems.model.Timesheet;
import org.springframework.data.repository.CrudRepository;

public interface TimesheetRepository extends CrudRepository<Timesheet,Integer> {

}
