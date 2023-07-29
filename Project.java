import java.util.ArrayList;
import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
    }

    public String getProjectName(){
        return name;
    }

    // TODO: Lengkapi logika menambahkan anggota proyek
    public void addMember(Employee employee) {
        boolean sudahAdaManager = false;

        if (memberList == null){
            this.memberList = new ArrayList<>();
        }

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
        }
    }


    // TODO: Lengkapi logika menghapus anggota proyek
    public void removeMember(Employee employee) {

    }
}
