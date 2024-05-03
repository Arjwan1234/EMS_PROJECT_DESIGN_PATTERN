package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
    private Command searchCommand;
    private Command printCommand;

    JTable table;
    Choice cEmployeeId;
    JButton btnSearch, btnPrint, btnUpdate, btnBack;
    
    ViewEmployee() {
        setTitle("View Employee Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchLabel = new JLabel("Search by Employee ID:");
        searchLabel.setBounds(20, 20, 150, 20);
        add(searchLabel);
        
        cEmployeeId = new Choice();
        cEmployeeId.setBounds(180, 20, 150, 20);
        populateEmployeeIds();
        add(cEmployeeId);
        
        table = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(0, 100, 900, 600);
        add(tableScrollPane);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(20, 70, 80, 20);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        btnPrint = new JButton("Print");
        btnPrint.setBounds(120, 70, 80, 20);
        btnPrint.addActionListener(this);
        add(btnPrint);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(220, 70, 80, 20);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(320, 70, 80, 20);
        btnBack.addActionListener(this);
        add(btnBack);
        
        // Initialize the commands
        searchCommand = new SearchCommand(this, cEmployeeId.getSelectedItem());
        printCommand = new PrintCommand(this);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    private void populateEmployeeIds() {
        // Populate the choice dropdown with employee IDs
        try {
            Conn conn = Conn.getInstance();
            ResultSet rs = conn.getStatement().executeQuery("SELECT empId FROM employee");
            while (rs.next()) {
                cEmployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void searchEmployee(String empId) {
        // Perform search and update the table with results
        String query = "SELECT * FROM employee WHERE empId = '" + empId + "'";
        try {
            Conn conn = Conn.getInstance();
            ResultSet rs = conn.getStatement().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void printEmployeeData() {
        // Print the current data in the table
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSearch) {
            // Execute the search command
            searchCommand.execute();
        } else if (ae.getSource() == btnPrint) {
            // Execute the print command
            printCommand.execute();
        } else if (ae.getSource() == btnUpdate) {
            setVisible(false);
            new UpdateEmployee(cEmployeeId.getSelectedItem());
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
