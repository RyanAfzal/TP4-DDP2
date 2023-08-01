public class Marketing extends Division {

    public Marketing(int baseSalary) {
        super(baseSalary);
    }
    
    @Override
    /**
     * Override method menambah karyawan ke divisi Marketing
     */
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        employee.setDivision(this);
        String output = "Karyawan ";
        output += employee.getName() + " ";
        output += "berhasil ditambahkan ke divisi Marketing";
        System.out.println(output);   
    }

    @Override
    public String toString() {
        int banyakManager = 0;
        int banyakKaryawan = 0;
        for (Employee employee : this.getEmployeeList()) {
            if (employee instanceof Manager) {
                banyakManager += 1;
            } else {
                banyakKaryawan += 1;
            }
        }
        return "Divisi Marekting memiliki " + banyakKaryawan + " karyawan dengan " + banyakManager + " manager.";
    }
}
