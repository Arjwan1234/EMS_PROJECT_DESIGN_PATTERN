package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    // Random instance for generating employee IDs
    Random ran = new Random();
    int number = ran.nextInt(999999);

    // Input fields
    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox<String> cbeducation, cbType;  // Add combo box for selecting employee type
    JLabel lblempId;
    JButton add, back;

    // Constructor
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Set up UI elements
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        // Employee type selection (Staff, Intern, etc.)
        JLabel labelType = new JLabel("Employee Type");
        labelType.setBounds(50, 100, 150, 30);
        labelType.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelType);

        String[] types = {"Staff", "Intern", "Other"};  // Add other types as necessary
        cbType = new JComboBox<>(types);
        cbType.setBounds(200, 100, 150, 30);
        add(cbType);
        
        // Name input field
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        // Father's name input field
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        // Date of birth input field
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        // Salary input field
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        // Address input field
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        // Phone input field
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        // Email input field
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        // Highest education input field
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String[] courses = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
        // Designation input field
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        // Aadhar number input field
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        // Employee ID label
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        // Add and Back buttons
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        // Set up frame size and location
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        // Get input values from UI fields
        String type = (String) cbType.getSelectedItem();  // Employee type (e.g., Staff, Intern)
        String name = tfname.getText();
        String fatherName = tffname.getText();
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String salary = tfsalary.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String education = (String) cbeducation.getSelectedItem();
        String designation = tfdesignation.getText();
        String aadhar = tfaadhar.getText();
        String empId = lblempId.getText();

        // Create Employee instance using EmployeeFactory
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.createEmployee(
            type,
            name, fatherName, dob, salary, address, phone,
            email, education, designation, aadhar, empId
        );

        // Database connection
        try {
            Conn conn = Conn.getInstance();
            // Update query to include the new 'type' column
       String query = "INSERT INTO employee (type, name, fname, dob, salary, address, phone, email, education, designation, aadhar, empId) "
            + "VALUES ('" + type + "', '" + employee.getName() + "', '"
            + employee.getFatherName() + "', '" + employee.getDob() + "', '"
            + employee.getSalary() + "', '" + employee.getAddress() + "', '"
            + employee.getPhone() + "', '" + employee.getEmail() + "', '"
            + employee.getEducation() + "', '" + employee.getDesignation() + "', '"
            + employee.getAadhar() + "', '" + employee.getEmpId() + "')";


            conn.getStatement().executeUpdate(query);
            // Notify user
            JOptionPane.showMessageDialog(null, "Details added successfully");
            setVisible(false);
            new Home();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding details. Please try again.");
        }
    } else {
        // If back button is pressed, go back
        setVisible(false);
        new Home();
    }
}


    // Main method
    public static void main(String[] args) {
        new AddEmployee();
    }
}
