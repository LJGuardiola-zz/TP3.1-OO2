package model.interfaces;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> load();
}
