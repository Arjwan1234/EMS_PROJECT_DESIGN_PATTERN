package employee.management.system;

public class UpdateDetailsCommand implements Command {
    private UpdateEmployee updateEmployee;

    public UpdateDetailsCommand(UpdateEmployee updateEmployee) {
        this.updateEmployee = updateEmployee;
    }

    @Override
    public void execute() {
        updateEmployee.updateDetails();
    }
}
