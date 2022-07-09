package com.task.ems.services;

import com.task.ems.model.*;
import com.task.ems.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTest {
    @Autowired
    EmployeeRepository empRepo;

    @Test
    public void testEmpCreateReadDelete() {
        Employee emp = new Employee("Random", "7354239231", "Sales",
                "rand@ps.com", "White House, Washington, USA ", 'A');

        empRepo.save(emp);
        Iterable<Employee> employees = empRepo.findAll();
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Random");

        empRepo.deleteAll();
        Assertions.assertThat(empRepo.findAll()).isEmpty();
    }

    @Autowired
    TimesheetRepository timeRepo;

    @Test
    public void testTimeCreateReadDelete() {
        Timesheet time = new Timesheet( 40, "26/12/2000",
                "Training", "PA-3");

        timeRepo.save(time);
        Iterable<Timesheet> timesheets = timeRepo.findAll();
        Assertions.assertThat(timesheets).extracting(Timesheet::getTimeTask).contains("Training");

        timeRepo.deleteAll();
        Assertions.assertThat(timeRepo.findAll()).isEmpty();
    }

    @Autowired
    LoginRepository logRepo;

    @Test
    public void testValidLoginCredentials() {
        String username = "joshin.rexy";
        String password = "ownerofthehouse";

        Iterable<Login> logins = logRepo.findAll();
        Assertions.assertThat(logins).extracting(Login::getLoginUsername).contains(username);
        Assertions.assertThat(logins).extracting(Login::getLoginPassword).contains(password);
    }

    @Test
    public void testInvalidLoginCredentials() {
        String username = "randomuser";
        String password = "randompass";

        Iterable<Login> logins = logRepo.findAll();
        Assertions.assertThat(logins).extracting(Login::getLoginUsername).doesNotContain(username);
        Assertions.assertThat(logins).extracting(Login::getLoginPassword).doesNotContain(password);
    }
}
