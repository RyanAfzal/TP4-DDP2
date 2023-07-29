import java.util.ArrayList;
import java.util.List;

public class Employee {
    // TODO: Tambahkan modifier untuk atribut
    protected String name;
    protected int yearsOfExperience;
    protected int salaryMultiplier;
    protected Division division;
    protected List<Project> projects = new ArrayList<>();

    // TODO: Lengkapi constructor
    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = (int) salaryMultiplier;
    }

    public int calculateSalary() {
        // TODO Lengkapi logika untuk menghitung gaji
        return (division.getBaseSalary()*(1 + this.salaryMultiplier + this.yearsOfExperience /10 ));
    }

    public String getDivisionName() {
        //TODO: Lengkapi logika untuk mendapat string nama divisi
        return "";
    }

    public String getProjectsString() {
        //TODO: Lengkapi logika untuk mendapat string daftar proyek
        return projects.toString();
    }

    public String getName() {
        return name;
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan

    public List<Project> getProjectList(){
        return projects;
    }
}
