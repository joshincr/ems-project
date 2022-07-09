package com.task.ems.controller;

import com.task.ems.model.Login;
import com.task.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    @Autowired
    private LoginService logService;

    // Create
    @PostMapping(value = "/login")
    public Login saveLogin(@RequestBody Login log) {
        logService.createLogin(log);
        return log;
    }

    // Update
    @PutMapping("/login")
    public Login changeEmployee(@RequestBody Login log) {
        logService.updateLogin(log);
        return log;
    }

    // Get Role
    @GetMapping("/getRole/{loginId}")
    char getLoginRole(@PathVariable int loginId) {
        return logService.getLoginRole(loginId);
    }


}
