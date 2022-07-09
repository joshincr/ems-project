package com.task.ems.service.impl;

import com.task.ems.model.Login;
import com.task.ems.repository.LoginRepository;
import com.task.ems.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository logRepository;

    @Override
    public void createLogin(Login log) {
        logRepository.save(log);
    }

    @Override
    public void updateLogin(Login log) {
        logRepository.save(log);
    }

    @Override
    public char getLoginRole(int logId) {
        Login log = logRepository.findById(logId).get();
        return log.getLoginRole();
    }

}
