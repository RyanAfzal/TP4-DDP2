import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void calculateSalaryTest(){
        Employee fira = new Employee("Fira", 1, 0.05);
        Division hrd = new HRD(5000000);
        hrd.addEmployee(fira);
        int expectedOutput = 5250000;
        int actualOutput = fira.calculateSalary();
        assertEquals(expectedOutput, actualOutput);
    }
}
