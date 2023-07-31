import java.util.ArrayList;
import java.util.List;

public class Employee {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    private int yearsOfExperience;
    private double salaryMultiplier;
    private Division division;
    private List<Project> projects = new ArrayList<>();

    // TODO: Lengkapi constructor
    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
    }

    public int calculateSalary() {
        // TODO Lengkapi logika untuk menghitung gaji
        return (int)(division.getBaseSalary()*(1 + this.salaryMultiplier + this.yearsOfExperience /10 ));
    }

    public String getDivisionName() {
        //TODO: Lengkapi logika untuk mendapat string nama divisi
        return division.getClass().getName();
    }

    public String getProjectsString() {
        //TODO: Lengkapi logika untuk mendapat string daftar proyek
        String projectString = new String();

        if (projects.size() == 0){
            return "Tidak ada proyek";
        }

        else{
            for (int i = 0 ; i < projects.size() ; i++){
                projectString += projects.get(i).getProjectName();
                if (i != projects.size()-1){
                    projectString += " , ";
                }
            }

            return projectString;
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += this.getName() + " - ";
        result += this.calculateSalary() + " - ";
        if (projects.size() == 0) {
            result += "Tidak memiliki proyek";
        } 
        else {
            result += this.getProjectsString();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setDivision(Division division){
        this.division = division;
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan

    public List<Project> getProjectList(){
        return projects;
    }
}
