package model;


import model.interfaces.EmailService;
import model.interfaces.EmployeeRepository;

public class EmployeeBirthday {

    private final EmployeeRepository repository;
    private final EmailService email;

    public EmployeeBirthday(EmployeeRepository repository, EmailService email) {
        this.repository = repository;
        this.email = email;
    }

    public void sendEmails() {
        repository.load().stream().filter(Employee::birthday).forEach(
                employee -> email.send(
                        employee.getEmail(),
                        "Saludo de cumpleaños",
                        "¡Feliz cumpleaños " + employee.getName() + "!"
                )
        );
    }

}
