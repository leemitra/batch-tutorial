package test.practice.tutorial.service;

import test.practice.tutorial.model.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();
}
