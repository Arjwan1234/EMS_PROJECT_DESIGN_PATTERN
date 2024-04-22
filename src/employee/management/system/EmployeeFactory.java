package employee.management.system;

public class EmployeeFactory {
    public Employee createEmployee(String type, String name, String fatherName, String dob, 
                                   String salary, String address, String phone, String email, 
                                   String education, String designation, String aadhar, String empId) {
        switch (type.toLowerCase()) {
            case "staff":
                return new Staff(name, fatherName, dob, salary, address, phone, email,
                                   education, designation, aadhar, empId);
            // Add cases for other employee types (e.g., Staff, Intern) and instantiate them accordingly.
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }
}
