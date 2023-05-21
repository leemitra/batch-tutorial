package test.practice.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.practice.tutorial.model.Employee;
import test.practice.tutorial.service.EmployeeService;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public void add() {
        employeeService.addEmployee();
    }

    @GetMapping("/findall")
    public ArrayList<Employee> getAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/findbyid/{id}")
    public Employee getEmployeeUsingId(@PathVariable long id) {
        return employeeService.findAllEmployeeByID(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        employeeService.deleteAllData();
    }
}
