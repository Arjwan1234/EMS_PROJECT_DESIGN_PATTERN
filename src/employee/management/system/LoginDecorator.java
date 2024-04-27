package employee.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class LoginDecorator implements ActionListener {
    protected ActionListener login;

    public LoginDecorator(ActionListener login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Delegate actionPerformed to the decorated object
        login.actionPerformed(e);
    }
}
