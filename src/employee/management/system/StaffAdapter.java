package employee.management.system;

public class StaffAdapter implements Employee {
    private Staff staff;

    public StaffAdapter(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String getName() {
        return staff.getName();
    }

    @Override
    public String getFatherName() {
        return staff.getFatherName();
    }

    @Override
    public String getDob() {
        return staff.getDob();
    }

    @Override
    public String getSalary() {
        return staff.getSalary();
    }

    @Override
    public String getAddress() {
        return staff.getAddress();
    }

    @Override
    public String getPhone() {
        return staff.getPhone();
    }

    @Override
    public String getEmail() {
        return staff.getEmail();
    }

    @Override
    public String getEducation() {
        return staff.getEducation();
    }

    @Override
    public String getDesignation() {
        return staff.getDesignation();
    }

    @Override
    public String getAadhar() {
        return staff.getAadhar();
    }

    @Override
    public String getEmpId() {
        return staff.getEmpId();
    }
}
