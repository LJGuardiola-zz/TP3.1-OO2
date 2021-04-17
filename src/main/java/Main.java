import db.EmployeeRepositoryFile;
import model.EmployeeBirthday;

public class Main {
    public static void main(String[] args) {
        new EmployeeBirthday(
                new EmployeeRepositoryFile()
        ).sendEmails();
    }
}
