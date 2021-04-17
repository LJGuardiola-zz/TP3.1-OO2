package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthdate;
    private final String email;

    public Employee(String firstName, String lastName, String birthdate, String email) {

        if (firstName == null || firstName.isEmpty())
            throw new RuntimeException("El nombre no puede ser nulo o vacío.");
        this.firstName = firstName;

        if (lastName == null || lastName.isEmpty())
            throw new RuntimeException("El apellido no puede ser nulo o vacío.");
        this.lastName = lastName;

        if (birthdate == null || birthdate.isEmpty())
            throw new RuntimeException("La fecha de nacimiento no puede ser nulo o vacío.");
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        if (email == null || email.isEmpty())
            throw new RuntimeException("El email no puede ser nulo o vacío.");
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public String getEmail() {
        return email;
    }

    public boolean birthday() {
        LocalDate now = LocalDate.now();
        return birthdate.getDayOfMonth() == now.getDayOfMonth() &&
                birthdate.getMonth().equals(now.getMonth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                birthdate.equals(employee.birthdate) &&
                email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthdate, email);
    }

}
