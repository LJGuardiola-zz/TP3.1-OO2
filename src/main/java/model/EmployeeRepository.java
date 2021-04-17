package model;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> load();
}
