package employee.management.system;

public class Staff implements Employee {
    private String name;
    private String fatherName;
    private String dob;
    private String salary;
    private String address;
    private String phone;
    private String email;
    private String education;
    private String designation;
    private String aadhar;
    private String empId;

    // Constructor
    public Staff(String name, String fatherName, String dob, String salary, String address,
                   String phone, String email, String education, String designation,
                   String aadhar, String empId) {
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.designation = designation;
        this.aadhar = aadhar;
        this.empId = empId;
    }
    // Implement Employee interface methods
    public String getName() { return name; }
    public String getFatherName() { return fatherName; }
    public String getDob() { return dob; }
    public String getSalary() { return salary; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getEducation() { return education; }
    public String getDesignation() { return designation; }
    public String getAadhar() { return aadhar; }
    public String getEmpId() { return empId; }
}
