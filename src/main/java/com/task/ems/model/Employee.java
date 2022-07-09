package com.task.ems.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private int empId;
    @Column(name = "empname")
    private String empName;
    @Column(name = "empcontact")
    private String empContact;
    @Column(name = "empdepartment")
    private String empDepartment;
    @Column(name = "empemail")
    private String empEmail;
    @Column(name = "empaddress")
    private String empAddress;
    @Column(name = "emprole")
    private char empRole;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
//    private Login login;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Timesheet> timesheet = new ArrayList<>();

    public Employee(String empName, String empContact, String empDepartment, String empEmail, String empAddress, char empRole) {
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empRole = empRole;
    }
}
