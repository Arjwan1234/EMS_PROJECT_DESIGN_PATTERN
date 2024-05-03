
package employee.management.system;
class PrintCommand implements Command {
    private ViewEmployee viewEmployee;

    public PrintCommand(ViewEmployee viewEmployee) {
        this.viewEmployee = viewEmployee;
    }

    @Override
    public void execute() {
        viewEmployee.printEmployeeData(); // Call the method to print data
    }
}