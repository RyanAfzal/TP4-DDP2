import java.util.List;

public class Division {
    // TODO: Tambahkan modifier untuk atribut
    protected int baseSalary;
    protected List<Employee> employeeList;

    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    // TODO: Lengkapi logika untuk menambahkan karyawan
    public void addEmployee(Employee employee) {

    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan

    /**
     * getter untuk mendapatkan division base salary
     * @return mengembalikan division base salary
     */
    public int getBaseSalary(){
        return baseSalary;
    }
}
