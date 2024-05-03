package employee.management.system;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSubject {
    private List<Observer> observers = new ArrayList<>();
    private String employeeData;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(employeeData);
        }
    }

    public void setEmployeeData(String data) {
        this.employeeData = data;
        notifyObservers();
    }
}
