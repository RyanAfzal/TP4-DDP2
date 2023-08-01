import java.util.ArrayList;
import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList = new ArrayList<>();;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
    }

    /**
     * Untuk mendapatkan nama proyek
     * @return nama proyek
     */
    public String getProjectName(){
        return name;
    }

    /**
     * Untuk mendapatkan leader proyek
     * @return leader proyek
     */
    public Manager getProjectLeader(){
        return projectLeader;
    }

    /**
     * Untuk Mendapatkan list member proyek
     * @return list member proyek
     */
    public List<Employee> getMemberList(){
        return memberList;
    }

    /**
     * Untuk menambahkan anggota proyek
     * @param employee karyawan (calon anggota)
     */
    // TODO: Lengkapi logika menambahkan anggota proyek
    public void addMember(Employee employee) {
        if (this.projectLeader == null){
            if (employee instanceof Manager){
                this.projectLeader = (Manager) employee;
                employee.getProjectList().add(this);
            }

            else{
                this.memberList.add(employee);
                employee.getProjectList().add(this);
            }
        }

        else{
            this.memberList.add(employee);
            employee.getProjectList().add(this);
        }
    }


    /**
     * Untuk menghapus member proyek
     * @param employee karyawan
     */
    // TODO: Lengkapi logika menghapus anggota proyek
    public void removeMember(Employee employee) {
        this.memberList.remove(employee);
        employee.getProjectList().remove(this);
    }
}
