package employee.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggingLoginDecorator extends LoginDecorator {

    public LoggingLoginDecorator(ActionListener login) {
        super(login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Log the event (you can customize this as needed)
        System.out.println("Action event occurred: " + e.getActionCommand());

        // Call the actionPerformed method of the decorated object
        super.actionPerformed(e);
    }
}
