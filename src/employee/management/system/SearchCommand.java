
package employee.management.system;
class SearchCommand implements Command {
    private ViewEmployee viewEmployee;
    private String empId;

    public SearchCommand(ViewEmployee viewEmployee, String empId) {
        this.viewEmployee = viewEmployee;
        this.empId = empId;
    }

    @Override
    public void execute() {
        viewEmployee.searchEmployee(empId); // Call the method to search employee
    }
}