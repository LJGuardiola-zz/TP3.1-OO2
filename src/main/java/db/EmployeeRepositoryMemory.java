package db;

import model.Employee;
import model.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class EmployeeRepositoryMemory implements EmployeeRepository {

    private final Employee[] employees = {
            new Employee("Young", "Angus", "1982/04/18", "angus@acdc.com"),
            new Employee("Johnson", "Brian", "1975/09/11", "brian@acdc.com"),
            new Employee("Jame", "Smith", "1982/04/16", "jwill@acdc.com")
    };

    @Override
    public List<Employee> load() {
        return Arrays.asList(employees);
    }

}
