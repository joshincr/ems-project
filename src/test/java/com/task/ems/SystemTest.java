package com.task.ems;

import com.task.ems.model.Employee;
import com.task.ems.model.Timesheet;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTest {
    @Test
    public void testEmpCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/employee";

        Employee employee = new Employee("Random", "7354239231", "Sales",
                "rand@ps.com", "White House, Washington, USA", 'A');
        ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);

        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Random");

        int size = restTemplate.getForObject(url, Employee[].class).length;
        restTemplate.delete(url + "/" + entity.getBody().getEmpId());
        Assertions.assertThat(restTemplate.getForObject(url, Employee[].class).length == --size);
    }

    @Test
    public void testTimeCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/timesheet";

        Timesheet time = new Timesheet(40, "26/12/2000",
                "Training", "PA-3");
        ResponseEntity<Timesheet> entity = restTemplate.postForEntity(url, time, Timesheet.class);

        Timesheet[] timesheets = restTemplate.getForObject(url, Timesheet[].class);
        Assertions.assertThat(timesheets).extracting(Timesheet::getTimeTask).contains("Training");

        int size = restTemplate.getForObject(url, Timesheet[].class).length;
        restTemplate.delete(url + "/" + entity.getBody().getTimesheetId());
        Assertions.assertThat(restTemplate.getForObject(url, Timesheet[].class).length == --size);
    }

}
