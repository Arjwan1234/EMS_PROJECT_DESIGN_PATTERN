package employee.management.system;

import java.sql.*;

public class Conn {
    
    private static Conn instance;
    private Connection c;
    private Statement s;

    // Private constructor to prevent instantiation from outside
    private Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Static method to get the singleton instance
    public static Conn getInstance() {
        if (instance == null) {
            instance = new Conn();
        }
        return instance;
    }

    // Method to get the statement object
    public Statement getStatement() {
        return s;
    }
}
