package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    private JComboBox<String> cbType;

    private JTextField tfEducation, tfFatherName, tfAddress, tfPhone, tfEmail, tfSalary, tfDesignation;
    private JLabel lblEmpId, lblName, lblDob, lblAadhar;
    private JButton btnUpdate, btnBack;
    private String empId;

    public UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setUpUI();
        populateEmployeeDetails(empId);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    private void setUpUI() {
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        // Employee type selection (Staff, Intern, etc.)
        JLabel labelType = new JLabel("Employee Type");
        labelType.setBounds(50, 100, 150, 30);
        labelType.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelType);

        String[] types = {"Staff", "Intern", "Other"}; // Add other types as necessary
        cbType = new JComboBox<>(types);
        cbType.setBounds(200, 100, 150, 30);
        add(cbType);

        createLabel("Name", 50, 150);
        lblName = createLabel("", 200, 150);

        createLabel("Father's Name", 400, 150);
        tfFatherName = createTextField(600, 150);

        createLabel("Date of Birth", 50, 200);
        lblDob = createLabel("", 200, 200);

        createLabel("Salary", 400, 200);
        tfSalary = createTextField(600, 200);

        createLabel("Address", 50, 250);
        tfAddress = createTextField(200, 250);

        createLabel("Phone", 400, 250);
        tfPhone = createTextField(600, 250);

        createLabel("Email", 50, 300);
        tfEmail = createTextField(200, 300);

        createLabel("Highest Education", 400, 300);
        tfEducation = createTextField(600, 300);

        createLabel("Designation", 50, 350);
        tfDesignation = createTextField(200, 350);

        createLabel("Aadhar Number", 400, 350);
        lblAadhar = createLabel("", 600, 350);

        createLabel("Employee ID", 50, 400);
        lblEmpId = createLabel("", 200, 400);

        btnUpdate = new JButton("Update Details");
        btnUpdate.setBounds(250, 550, 150, 40);
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);

        btnBack = new JButton("Back");
        btnBack.setBounds(450, 550, 150, 40);
        btnBack.addActionListener(this);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 30);
        label.setFont(new Font("serif", Font.PLAIN, 20));
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 150, 30);
        add(textField);
        return textField;
    }

    private void populateEmployeeDetails(String empId) {
        try {
            Conn conn = Conn.getInstance();
            String query = "SELECT * FROM employee WHERE empId = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                lblName.setText(rs.getString("name"));
                tfFatherName.setText(rs.getString("fname"));
                lblDob.setText(rs.getString("dob"));
                tfAddress.setText(rs.getString("address"));
                tfSalary.setText(rs.getString("salary"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                tfEducation.setText(rs.getString("education"));
                lblAadhar.setText(rs.getString("aadhar"));
                lblEmpId.setText(rs.getString("empId"));
                tfDesignation.setText(rs.getString("designation"));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving employee details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnUpdate) {
            updateEmployeeDetails();
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            new Home();
        }
    }

    private void updateEmployeeDetails() {
        String fatherName = tfFatherName.getText();
        String salary = tfSalary.getText();
        String address = tfAddress.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String education = tfEducation.getText();
        String designation = tfDesignation.getText();
        String employeeType = cbType.getSelectedItem().toString();

        Conn conn = Conn.getInstance();
        try {
            Connection connection = conn.getConnection();
            String query = "UPDATE employee SET fname = ?, salary = ?, address = ?, phone = ?, email = ?, education = ?, designation = ?,type = ? WHERE empId = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, fatherName);
            pstmt.setString(2, salary);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setString(6, education);
            pstmt.setString(7, designation);
            pstmt.setString(8, employeeType);
            pstmt.setString(9, empId);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Details updated successfully");
            setVisible(false);
            new Home();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating employee details: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
