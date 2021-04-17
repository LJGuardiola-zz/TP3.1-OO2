package db;

import model.Employee;
import model.EmployeeRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepositoryFile implements EmployeeRepository {

    private static final File FILE = new File("employees.txt");

    @Override
    public List<Employee> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            return reader.lines()
                    .map(line -> line.split(", "))
                    .map(str -> new Employee(str[0], str[1], str[2], str[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de empleados.", e);
        }
    }

}
