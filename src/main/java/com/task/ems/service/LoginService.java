package com.task.ems.service;
import com.task.ems.model.Employee;
import com.task.ems.model.Login;

import java.util.List;

public interface LoginService  {

    // Create
    void createLogin(Login log);

    // Update
    void updateLogin(Login log);

    // Get Role
    char getLoginRole(int loginId);
}
