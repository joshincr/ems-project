package com.task.ems.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "timesheet")
@Data
@NoArgsConstructor
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheetid")
    private int timesheetId;
    @Column(name = "empid")
    private int empId;
    @Column(name = "timetotalhours")
    private int timeTotalHours;
    @Column(name = "timedate")
    private String timeDate;
    @Column(name = "timetask")
    private String timeTask;
    @Column(name = "timedescription")
    private String timeDescription;

//    @ManyToOne
//    @JoinColumn(name = "empid")
//    private Employee emp;


    public Timesheet(int timeTotalHours, String timeDate, String timeTask, String timeDescription) {
        this.timeTotalHours = timeTotalHours;
        this.timeDate = timeDate;
        this.timeTask = timeTask;
        this.timeDescription = timeDescription;
    }
}
