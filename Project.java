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

    public String getProjectName(){
        return name;
    }

    public Manager getProjectLeader(){
        return projectLeader;
    }

    public List<Employee> getMemberList(){
        return memberList;
    }

    // TODO: Lengkapi logika menambahkan anggota proyek
    public void addMember(Employee employee) {
        boolean sudahAdaManager = false;

        for (Employee member : memberList){
            if (member instanceof Manager){
                sudahAdaManager = true;
            }
        }

        if (employee instanceof Manager && sudahAdaManager == false){
            this.projectLeader = (Manager) employee;
        }

        else{
            this.memberList.add(employee);
            employee.getProjectList().add(this);
        }
    }


    // TODO: Lengkapi logika menghapus anggota proyek
    public void removeMember(Employee employee) {
        this.memberList.remove(employee);
        employee.getProjectList().remove(this);
    }
}
