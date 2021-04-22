import db.EmployeeRepositoryFile;
import model.EmployeeBirthday;
import services.email.EmailWrapper;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        new EmployeeBirthday(
                new EmployeeRepositoryFile("employees.txt"),
                new EmailWrapper()
        ).sendEmails();
    }
}
