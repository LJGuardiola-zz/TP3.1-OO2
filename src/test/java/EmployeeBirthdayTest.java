import db.EmployeeRepositoryMemory;
import model.EmployeeBirthday;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EmployeeBirthdayTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void send_email_to_birthday_boys() {
        new EmployeeBirthday(new EmployeeRepositoryMemory()).sendEmails();
        Assertions.assertEquals("Se envió el email correctamente", outputStreamCaptor.toString().trim());
    }

    @AfterAll
    static void afterAll() {
        System.setOut(System.out);
    }

}
