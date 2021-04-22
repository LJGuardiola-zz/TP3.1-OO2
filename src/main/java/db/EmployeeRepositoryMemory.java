package db;

import model.Employee;
import model.interfaces.EmployeeRepository;

import java.util.List;
import java.util.Arrays;

public class EmployeeRepositoryMemory implements EmployeeRepository {

    private final Employee[] employees;

    public EmployeeRepositoryMemory(Employee... employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> load() {
        return Arrays.asList(employees);
    }

}
