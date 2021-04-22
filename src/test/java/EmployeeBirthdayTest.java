import db.EmployeeRepositoryMemory;
import model.Employee;
import model.EmployeeBirthday;
import org.junit.jupiter.api.Test;
import services.email.EmailWrapperTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeBirthdayTest {

    private final EmployeeRepositoryMemory repository = new EmployeeRepositoryMemory(
            new Employee("Young", "Angus", getTodayDate(), "angus@acdc.com"),
            new Employee("Johnson", "Brian", "1975/09/11", "brian@acdc.com")
    );

    private final EmailWrapperTest email = new EmailWrapperTest();

    @Test
    void send_email_to_birthday_boys() {
        new EmployeeBirthday(repository, email).sendEmails();
        assertTrue(
                email.verify("angus@acdc.com | Saludo de cumpleaños | ¡Feliz cumpleaños Young Angus!")
        );
    }

    private String getTodayDate() {
        return LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy/MM/dd")
        );
    }

}
