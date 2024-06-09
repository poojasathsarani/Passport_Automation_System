/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportautomationsystem;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class Admin {
    private AdminLogin LoginInstance;
    private String username;
    private String password;
    
    
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Admin(){
        
    }
    
    
     PASDBConnection ob = new PASDBConnection();
     Connection conn = ob.dbconnection();
    
    
    
    public boolean loginVerification(String username,String password){
        
            try{
            String sql = "SELECT username,password FROM admin WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                    if (LoginInstance != null) {
                        LoginInstance.dispose();
                    }
                    return true;
                }
                
                else {
                JOptionPane.showMessageDialog(null,"Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
                }
            }
            catch (SQLException e) {
                System.out.println(e);
                return false;
            }
    }
    
    
    
    
    
    
    
    
    public void AdminView(JTable viewTable) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = conn.prepareStatement("SELECT nic, nameWithInitials, fullName, permanentAddress, dateOfBirth, birthCertificateNo, birthCertificateDistrict, placeOfBirth, gender, age, profession, mobileNumber, email, policeStatus, paymentStatus, applicationStatus, passportStatus, appointmentDate, appointmentTime FROM application");
            resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) viewTable.getModel();
            dtm.setRowCount(0);
            while (resultSet.next()) {
                Vector<Object> v = new Vector<>();
                for (int i = 1; i <= n; i++) {
                    v.add(resultSet.getString("nic"));
                    v.add(resultSet.getString("nameWithInitials"));
                    v.add(resultSet.getString("fullName"));
                    v.add(resultSet.getString("permanentAddress"));
                    v.add(resultSet.getString("dateOfBirth"));
                    v.add(resultSet.getString("birthCertificateNo"));
                    v.add(resultSet.getString("birthCertificateDistrict"));
                    v.add(resultSet.getString("placeOfBirth"));
                    v.add(resultSet.getString("gender"));
                    v.add(resultSet.getString("age"));
                    v.add(resultSet.getString("profession"));
                    v.add(resultSet.getString("mobileNumber"));
                    v.add(resultSet.getString("email"));
                    v.add(resultSet.getString("policeStatus"));
                    v.add(resultSet.getString("paymentStatus"));
                    v.add(resultSet.getString("applicationStatus"));
                    v.add(resultSet.getString("passportStatus"));
                    v.add(resultSet.getString("appointmentDate"));
                    v.add(resultSet.getString("appointmentTime"));
                    
                    
                }
                dtm.addRow(v);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }
    }
    

    
    
    
    
    
    public void adminSearch(JTable viewTable, String applicationID) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = conn.prepareStatement("SELECT applicationID, nic, nameWithInitials, fullName, permanentAddress, dateOfBirth, birthCertificateNo, birthCertificateDistrict, placeOfBirth, gender, age, profession, mobileNumber, email, policeStatus, paymentStatus, applicationStatus, passportStatus, appointmentDate, appointmentTime FROM application where applicationID = ?");
            
            statement.setString(1, applicationID);
            
            resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            
            int n = rsmd.getColumnCount();
            
            DefaultTableModel dtm = (DefaultTableModel) viewTable.getModel();
            dtm.setRowCount(0);
            while (resultSet.next()) {
                Vector<Object> v = new Vector<>();
                for (int i = 1; i <= n; i++) {
                    v.add(resultSet.getString("applicationID"));
                    v.add(resultSet.getString("nic"));
                    v.add(resultSet.getString("nameWithInitials"));
                    v.add(resultSet.getString("fullName"));
                    v.add(resultSet.getString("permanentAddress"));
                    v.add(resultSet.getString("dateOfBirth"));
                    v.add(resultSet.getString("birthCertificateNo"));
                    v.add(resultSet.getString("birthCertificateDistrict"));
                    v.add(resultSet.getString("placeOfBirth"));
                    v.add(resultSet.getString("gender"));
                    v.add(resultSet.getString("age"));
                    v.add(resultSet.getString("profession"));
                    v.add(resultSet.getString("mobileNumber"));
                    v.add(resultSet.getString("email"));
                    v.add(resultSet.getString("policeStatus"));
                    v.add(resultSet.getString("paymentStatus"));
                    v.add(resultSet.getString("applicationStatus"));
                    v.add(resultSet.getString("passportStatus"));
                    v.add(resultSet.getString("appointmentDate"));
                    v.add(resultSet.getString("appointmentTime"));
                }
                dtm.addRow(v);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    
    
    
    
    
    
    
    private String getStatus(boolean pending, boolean verified, boolean rejected) {
    if (pending) {
        return "PENDING";
    } else if (verified) {
        return "VERIFIED";
    } else if (rejected) {
        return "REJECTED";
    } else {
        return "UNKNOWN";
    }
    }
    
    

    public void updatePoliceStatus(String applicationID, boolean policePending, boolean policeVerified, boolean policeRejected) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ob.dbconnection(); // Instantiate the connection object

            String sql = "UPDATE application SET policeStatus = ? WHERE applicationID = ?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, getStatus(policePending, policeVerified, policeRejected));
            preparedStatement.setString(2, applicationID);

            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate(); 

            if (rowsInserted > 0) { 
            System.out.println("Updated successfully!"); 
            }
            else { 
            System.out.println("Update Failed!"); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }








    public void updatePaymentStatus(String applicationID, boolean paymentPending, boolean paymentVerified, boolean paymentRejected) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ob.dbconnection(); // Instantiate the connection object

            String sql = "UPDATE application SET paymentStatus = ? WHERE applicationID = ?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, getStatus(paymentPending, paymentVerified, paymentRejected));
            preparedStatement.setString(2, applicationID);

            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate(); 

            if (rowsInserted > 0) { 
            System.out.println("Updated successfully!"); 
            }
            else { 
            System.out.println("Update Failed!"); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    public void updateApplicationStatus(String applicationID, boolean applicationPending, boolean applicationVerified, boolean applicationRejected) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ob.dbconnection(); // Instantiate the connection object

            String sql = "UPDATE application SET applicationStatus = ? WHERE applicationID = ?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, getStatus(applicationPending, applicationVerified, applicationRejected));
            preparedStatement.setString(2, applicationID);

            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate(); 

            if (rowsInserted > 0) { 
            System.out.println("Updated successfully!"); 
            }
            else { 
            System.out.println("Update Failed!"); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    public void updatePassportStatus(String applicationID, boolean passportPending, boolean passportVerified, boolean passportRejected) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ob.dbconnection(); // Instantiate the connection object

            String sql = "UPDATE application SET passportStatus = ? WHERE applicationID = ?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, getStatus(passportPending, passportVerified, passportRejected));
            preparedStatement.setString(2, applicationID);

            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate(); 

            if (rowsInserted > 0) { 
            System.out.println("Updated successfully!"); 
            }
            else { 
            System.out.println("Update Failed!"); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}