import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimProyek {
    public List<Project> projectList = new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    List<Division> divisionList = new ArrayList<>();

    public static void main(String[] args) {
        SimProyek app = new SimProyek();
        app.mockDivisionData();

        // Gunakan ini jika ingin menggunakan data awalan
        // Tidak wajib digunakan
        app.mockData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Selamat datang di SimProyek. Berikut adalah daftar proyek yang terdaftar dalam sistem.");
        
        // TODO: Tampilkan daftar proyek, lengkapi kode di dalam method printProjectList()
        app.printProjectList();

        do {
            app.printMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            int nomorPilihan;
            int nomorAnggota;
            String namaKaryawan;
            String jabatan;
            int lamaBekerja;
            double bonusGaji;

            //untuk pilih handle menu
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama proyek: ");
                    String projectName = scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.createProject(projectName);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();
                
                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan nama karyawan yang ingin ditambahkan: ");
                    namaKaryawan = scanner.nextLine();
                    
                    // TODO: Kerjakan di dalam method ini
                    app.addProjectMember(nomorPilihan, namaKaryawan);

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    app.projectDetail(nomorPilihan);

                    System.out.print("Masukkan nomor anggota yang ingin dihapus: ");
                    nomorAnggota = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.deleteProjectMember(nomorPilihan, nomorAnggota);

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.projectDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 5:
                    System.out.println("Daftar proyek pada sistem SimProyek");
                    app.printProjectList();

                    System.out.println();
                    break;
                case 6:
                    System.out.print("Nama karyawan: ");
                    namaKaryawan = scanner.nextLine();

                    System.out.print("Jabatan: ");
                    jabatan = scanner.nextLine();

                    System.out.print("Lama bekerja (tahun): ");
                    lamaBekerja = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Bonus gaji: ");
                    bonusGaji = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Divisi:");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");

                    System.out.print("Pilih divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.addEmployee(namaKaryawan, jabatan, lamaBekerja, bonusGaji, nomorPilihan);

                    System.out.println();
                    break;
                case 7:
                    String jabatanKaryawan = "";
                    System.out.println("Daftar karyawan pada sistem SimProyek ");
                    System.out.println("Nama - Divisi - Gaji - Proyek ");
                    for (int i = 0; i < app.employeeList.size(); i++) {
                        // untuk jabatan
                        if(app.employeeList.get(i) instanceof Manager){
                            jabatanKaryawan = "Manager";
                        }
                        else if(app.employeeList.get(i) instanceof Intern){
                            jabatanKaryawan = "Intern";
                        }
                        else{
                            jabatanKaryawan = "Karyawan";
                        }

                        System.out.printf("%d. %s - Divisi %s - %d - %s \n", 
                            i+1, 
                            // TODO: lengkapi logika di masing-masing method
                            jabatanKaryawan + " " + app.employeeList.get(i).getName() ,
                            app.employeeList.get(i).getDivisionName(),
                            app.employeeList.get(i).calculateSalary(),
                            app.employeeList.get(i).getProjectsString()
                        );
                    }

                    System.out.println();
                    break;
                case 8:
                    System.out.println("Berikut adalah daftar divisi pada sistem SimProyek: ");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");


                    System.out.print("Pilih nomor divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: tampilkan detail divisi
                    app.printDivisionDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 99:
                    System.out.println("Terima kasih telah menggunakan SimProyek.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 99);
        scanner.close();
    }

    // Silahkan tambahkan method lain yang dirasa dapat membantu

    //Untuk mencetak project yang dapat dipilih
    private void printProjectListNumberOnly() {
        for (int i = 0 ; i < projectList.size() ; i++){
            System.out.println((i+1) + " " + projectList.get(i).getProjectName());
        }
        System.out.println();
    }

    //Untuk mencetak detail tiap divisi
    private void printDivisionDetail(int nomorPilihan) {
        if (nomorPilihan < 0 || nomorPilihan > projectList.size()){
            System.out.println("Input invalid. Kembali ke menu utama");
        }

        else{
            Division division = divisionList.get(nomorPilihan - 1);
            System.out.println(division);
            for (int i = 0; i < division.getEmployeeList().size() ; i++) {
                System.out.println((i + 1) + ". " + division.getEmployeeList().get(i).toString());
            }
        }
    }

    //Untuk Menambah Karyawan
    private void addEmployee(String namaKaryawan, String jabatan, int lamaBekerja, double bonusGaji, int nomorDivisi) {
        Employee currentEmployee = null;
        if (jabatan.equals("Manager") || jabatan.equals("Intern") || jabatan.equals("Employee")){

            if(jabatan.equals("Manager")){
                currentEmployee = new Manager(namaKaryawan,lamaBekerja,bonusGaji);
            }

            else if(jabatan.equals("Intern")){
                currentEmployee = new Intern(namaKaryawan,lamaBekerja,bonusGaji);
            }

            else if(jabatan.equals("Employee")){
                currentEmployee = new Manager(namaKaryawan,lamaBekerja,bonusGaji);
            }


            employeeList.add(currentEmployee);
            currentEmployee.setDivision(divisionList.get(nomorDivisi-1));
            divisionList.get(nomorDivisi-1).addEmployee(currentEmployee);
        }

        else{
            System.out.println("Jabatan tidak tersedia");
        }
    }

    //Untuk mencetak daftar proyek
    private void printProjectList() {
        for(int i = 0 ; i < projectList.size() ; i++){
            System.out.println(projectList.get(i).getProjectName());
            //Untuk Project Leader
            if (projectList.get(i).getProjectLeader() == null){
                System.out.println("Leader: Tidak memiliki leader");
            }

            else{
                System.out.println("Leader: " + projectList.get(i).getProjectLeader().getName());
            }

            System.out.println("Jumlah anggota: " + projectList.get(i).getMemberList().size());
            System.out.println();
        }
    }

    //Untuk mencetak detail proyek
    private void projectDetail(int nomorPilihan) {
        if (nomorPilihan < 0 || nomorPilihan > projectList.size()){
            System.out.println("Input invalid");
        }

        else{
            System.out.println(projectList.get(nomorPilihan-1).getProjectName());
            //Untuk Project Leader
            if (projectList.get(nomorPilihan-1).getProjectLeader() == null){
                System.out.println("Leader: Tidak memiliki leader");
            }

            else{
                System.out.println("Leader: " + projectList.get(nomorPilihan-1).getProjectLeader().getName() + " - Divisi " + projectList.get(nomorPilihan-1).getProjectLeader().getDivisionName());
            }

            //Untuk anggota
            if (projectList.get(nomorPilihan-1).getMemberList().size() == 0){
                System.out.println("Anggota: Tidak memiliki anggota");
            }

            else{
                System.out.println("Anggota: ");
                for (int i = 0 ; i < projectList.get(nomorPilihan-1).getMemberList().size();i++){
                    System.out.println((i+1) + " " +projectList.get(nomorPilihan-1).getMemberList().get(i).getName() + " - Divisi " + projectList.get(nomorPilihan-1).getMemberList().get(i).getDivisionName());
                }
            }
        }
    }

    //Untuk menghapus anggota proyek
    private void deleteProjectMember(int nomorPilihan, int nomorAnggota) {
        //Asumsi : tidak ada nama karyawan yang sama
        if (nomorPilihan < 0 || nomorPilihan > projectList.size()){
            System.out.println("Input invalid. Kembali ke menu utama.");
        }

        else{
            Employee employeeYangAkanDihapus = projectList.get(nomorPilihan-1).getMemberList().get(nomorAnggota-1);
            projectList.get(nomorPilihan-1).removeMember(employeeYangAkanDihapus);
            System.out.println("Anggota " + employeeYangAkanDihapus.getName() + " berhasil dihapus dari Proyek Baru.");
        }
    }

    //Untuk menambah anggota proyek
    private void addProjectMember(int nomorPilihan, String namaKaryawan) {
        //Asumsi : tidak ada nama karyawan yang sama
        boolean berhasilAddProjectmmber = false;

        if (nomorPilihan < 0 || nomorPilihan > projectList.size()){
            System.out.println("Input invalid. Kembali ke menu utama.");
        }
        else{
            for (Employee employee : employeeList){
                if (employee.getName().equals(namaKaryawan)){
                    if (employee instanceof Manager){
                        if(employee.getProjectList().size() < 3){
                            projectList.get(nomorPilihan-1).addMember(employee);
                            System.out.println("Karyawan " + employee.getName() + " berhasil ditambahkan ke proyek " + projectList.get(nomorPilihan-1).getProjectName());
                            berhasilAddProjectmmber = true;
                        }

                        else{
                            System.out.println("Gagal: karyawan "+ employee.getName()+ " hanya dapat mengikuti 3 proyek.");
                        }
                    }

                    else if (employee instanceof Intern){
                        if (employee.getProjectList().size() < 2){
                            projectList.get(nomorPilihan-1).addMember(employee);
                            System.out.println("Karyawan " + employee.getName() + " berhasil ditambahkan ke proyek " + projectList.get(nomorPilihan-1).getProjectName());
                            berhasilAddProjectmmber = true;
                        }

                        else{
                            System.out.println("Gagal: karyawan "+ employee.getName()+ " hanya dapat mengikuti 2 proyek.");
                        }
                    }

                    else{
                        if (employee.getProjectList().isEmpty()){
                            projectList.get(nomorPilihan-1).addMember(employee);
                            System.out.println("Karyawan " + employee.getName() + " berhasil ditambahkan ke proyek " + projectList.get(nomorPilihan-1).getProjectName());
                            berhasilAddProjectmmber = true;
                        }

                        else{
                            System.out.println("Gagal: Karyawan "+ employee.getName() + " sudah merupakan anggota dari proyek " + employee.getProjectList().get(0).getProjectName());
                        }
                    }
                }
            }

            if (berhasilAddProjectmmber == false){
                System.out.println("Tidak ada karyawan bernama " + namaKaryawan);
            }
        }
    }

    //Untuk membuat proyek
    private void createProject(String projectName) {
        boolean projectSudahada = false;
        for (Project project : projectList){
            if (project.getProjectName().equals(projectName)){
                projectSudahada = true;
            }
        }

        if (projectSudahada){
            System.out.println("Gagal: "+ projectName+ " telah terdaftar di dalam sistem");
        }

        else{
            projectList.add(new Project(projectName));
            System.out.println("Proyek "+projectName+" berhasil ditambahkan ke dalam sistem");
        }
    }

    //Untuk print menu yang tersedia
    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah proyek        ");
        System.out.println("2. Tambah anggota proyek");
        System.out.println("3. Hapus anggota proyek ");
        System.out.println("4. Detail proyek        ");
        System.out.println("5. Daftar proyek        ");
        System.out.println("6. Tambah karyawan      ");
        System.out.println("7. Daftar karyawan      ");
        System.out.println("8. Detail divisi        ");
        System.out.println("99. Keluar              ");
        System.out.print("Pilih menu: ");
    }
    
    private void mockDivisionData() {
        Division hrd = new HRD(5000000);
        Division marketing = new Marketing(7000000);
        Division design = new Design(6000000);
        Division engineering = new Engineering(8000000);

        divisionList.add(hrd);
        divisionList.add(marketing);
        divisionList.add(design);
        divisionList.add(engineering);
    }

    private void mockData() {
        Division hrd = this.divisionList.get(0);
        Division marketing = this.divisionList.get(1);
        Division design = this.divisionList.get(2);

        Manager budi = new Manager("Budi", 3, 0.2);
        Manager ica = new Manager("Ica", 5, 0.3);
        Manager andi = new Manager("Andi", 4, 0.25);

        Employee udin = new Employee("Udin", 2, 0.1);
        Employee fira = new Employee("Fira", 1, 0.05);
        Employee opet = new Employee("Opet", 3, 0.15);
        Employee mirna = new Employee("Mirna", 4, 0.2);
        Employee asep = new Employee("Asep", 2, 0.1);
        Employee yudi = new Employee("Yudi", 1, 0.05);
        Employee deni = new Employee("Deni", 3, 0.15);
        Employee tina = new Employee("Tina", 2, 0.1);

        this.employeeList.add(budi);
        this.employeeList.add(ica);
        this.employeeList.add(andi);
        this.employeeList.add(udin);
        this.employeeList.add(fira);
        this.employeeList.add(opet);
        this.employeeList.add(mirna);
        this.employeeList.add(asep);
        this.employeeList.add(yudi);
        this.employeeList.add(deni);
        this.employeeList.add(tina);
        
        hrd.addEmployee(budi);
        hrd.addEmployee(udin);
        hrd.addEmployee(fira);
        hrd.addEmployee(opet);

        marketing.addEmployee(ica);
        marketing.addEmployee(mirna);
        marketing.addEmployee(asep);
        marketing.addEmployee(yudi);

        design.addEmployee(andi);
        design.addEmployee(deni);
        design.addEmployee(tina);

        Project ufoProject = new Project("Proyek UFO");
        Project saladProject = new Project("Proyek Franchise Salad Buah Tanpa Semangka dan Melon");
        Project compfestProject = new Project("Website COMPFEST");

        ufoProject.addMember(budi);
        ufoProject.addMember(udin);
        ufoProject.addMember(fira);
        ufoProject.addMember(opet);

        saladProject.addMember(ica);
        saladProject.addMember(mirna);
        saladProject.addMember(asep);
        saladProject.addMember(yudi);

        compfestProject.addMember(andi);
        compfestProject.addMember(deni);
        compfestProject.addMember(tina);

        this.projectList.add(ufoProject);
        this.projectList.add(saladProject);
        this.projectList.add(compfestProject);
    }
}
