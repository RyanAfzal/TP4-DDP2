import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void calculateSalaryTest(){
        Employee fira = new Employee("Fira", 1, 0.05);
        int expectedOutput = 0;
        int actualOutput = fira.calculateSalary();
        assertEquals(expectedOutput, actualOutput);
    }
}
