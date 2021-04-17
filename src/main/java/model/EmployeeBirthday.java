package model;

import model.email.Email;
import model.email.SmtpException;

public class EmployeeBirthday {

    private final EmployeeRepository repository;

    public EmployeeBirthday(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void sendEmails() {
        repository.load().stream().filter(Employee::birthday).forEach(
                employee -> {
                    try {
                        new Email(
                                employee.getEmail(),
                                "Saludo de cumpleaños",
                                "¡Feliz cumpleaños " + employee.getName() + "!"
                        ).enviar();
                    } catch (SmtpException e) {
                        throw new RuntimeException("No se pudo enviar el email de cumpleaños.", e);
                    }
                }
        );
    }

}
