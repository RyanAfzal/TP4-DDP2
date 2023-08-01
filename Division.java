import java.util.ArrayList;
import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    private int baseSalary;
    private List<Employee> employeeList = new ArrayList<>();

    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    // TODO: Lengkapi logika untuk menambahkan karyawan
    /**
     * Method untuk menambahkan karyawan ke divisi
     * @param employee parameter karyawan
     */
    public void addEmployee(Employee employee) {
        if(employee instanceof Manager){
            employeeList.add(0, employee);
        }

        else{
            employeeList.add(employee);
        }
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan

    /**
     * getter untuk mendapatkan division base salary
     * @return mengembalikan division base salary
     */
    public int getBaseSalary(){
        return baseSalary;
    }

    /**
     * Untuk mendapatkan daftar karyawan
     * @return mengembalikan daftar karyawan
     */
    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
