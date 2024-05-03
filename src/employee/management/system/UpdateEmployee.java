package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    private Command updateDetailsCommand;
    
    private JTextField tfEducation, tfFatherName, tfAddress, tfPhone, tfEmail, tfSalary, tfDesignation;
    private JLabel lblEmpId, lblAadhar;
    private JButton updateButton, backButton;
    private String empId;

    public UpdateEmployee(String empId) {
        this.empId = empId;
        this.updateDetailsCommand = new UpdateDetailsCommand(this);

        setTitle("Update Employee Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        heading.setBounds(320, 30, 500, 50);
        add(heading);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 150, 150, 30);
        lblName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblName);

        JLabel lblFatherName = new JLabel("Father's Name:");
        lblFatherName.setBounds(50, 200, 150, 30);
        lblFatherName.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblFatherName);

        JLabel lblDob = new JLabel("Date of Birth:");
        lblDob.setBounds(50, 250, 150, 30);
        lblDob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblDob);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(50, 300, 150, 30);
        lblSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblSalary);

        tfFatherName = new JTextField();
        tfFatherName.setBounds(200, 150, 150, 30);
        add(tfFatherName);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 200, 150, 30);
        add(tfAddress);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 250, 150, 30);
        add(tfPhone);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        tfEducation = new JTextField();
        tfEducation.setBounds(200, 350, 150, 30);
        add(tfEducation);

        tfDesignation = new JTextField();
        tfDesignation.setBounds(200, 400, 150, 30);
        add(tfDesignation);

        tfSalary = new JTextField();
        tfSalary.setBounds(200, 450, 150, 30);
        add(tfSalary);

        lblEmpId = new JLabel();
        lblEmpId.setBounds(400, 150, 150, 30);
        add(lblEmpId);

        lblAadhar = new JLabel();
        lblAadhar.setBounds(400, 200, 150, 30);
        add(lblAadhar);

        updateButton = new JButton("Update");
        updateButton.setBounds(200, 500, 100, 30);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(350, 500, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        try {
            Conn conn = Conn.getInstance();
            String query = "SELECT * FROM employee WHERE empId = '" + empId + "'";
            ResultSet rs = conn.getStatement().executeQuery(query);

            while (rs.next()) {
                lblEmpId.setText(rs.getString("empId"));
                tfFatherName.setText(rs.getString("fname"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                tfEducation.setText(rs.getString("education"));
                tfDesignation.setText(rs.getString("designation"));
                lblAadhar.setText(rs.getString("aadhar"));
                tfSalary.setText(rs.getString("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(800, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    public void updateDetails() {
        try {
            Conn conn = Conn.getInstance();
            String query = "UPDATE employee SET fname = '" + tfFatherName.getText() + "', salary = '" + tfSalary.getText() + "', address = '" + tfAddress.getText() + "', phone = '" + tfPhone.getText() + "', email = '" + tfEmail.getText() + "', education = '" + tfEducation.getText() + "', designation = '" + tfDesignation.getText() + "' WHERE empId = '" + empId + "'";
            
            conn.getStatement().executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Details updated successfully");
            setVisible(false);
            new Home();  // Adjust as needed for your application
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            updateDetailsCommand.execute();
        } else if (ae.getSource() == backButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
