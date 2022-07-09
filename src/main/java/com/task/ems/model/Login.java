package com.task.ems.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginid")
    private int loginID;
    @Column(name = "empid")
    private int empID;
    @Column(name = "username")
    private String loginUsername;
    @Column(name = "password")
    private String loginPassword;
    @Column(name = "loginrole")
    private char loginRole;

//    @OneToOne()
//    @PrimaryKeyJoinColumn
//    private Employee employee;
}
