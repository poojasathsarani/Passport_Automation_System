/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportautomationsystem;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class Applicant {
    private ApplicantLogin loginInstance;
    private String username;
    private String password;
    private String nameWithInitials;
    private String fullName;
    private String validatedNIC;
    
    public Applicant(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Applicant(){
        
    }
   
    PASDBConnection ob1 = new PASDBConnection();
    Connection conn = ob1.dbconnection();
    
   


    public boolean loginVerification(String username,String password){
        
        
            try{
            String sql = "SELECT username,password FROM Applicant WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                    if (loginInstance != null) {
                        loginInstance.dispose();
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
   
    


    public int registerApplicant(String username, String password) {
        
    
        int applicantID = -1;
        
    try {
            // Create SQL statement 
            String sql = "INSERT INTO applicant (username, password) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);




            // Set values for parameters 
            statement.setString(1, username);
            statement.setString(2, password); 



            // Execute the statement 
            int rowsInserted = statement.executeUpdate(); 

            if (rowsInserted > 0) { 
            System.out.println("Data inserted successfully!"); 
            
            // Retrieve the generated registration ID
                var generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    applicantID = generatedKeys.getInt(1);
                }
            }
            else { 
            System.out.println("Data insertion Failed!"); 
            }

            }

            catch(SQLException e) {
                    System.out.println(e);
            }
    
            return applicantID;
    }
    
    
        
    
    
    
    
    public boolean checkNICValidation(String nicNumber, String dob) {

        try {
            String sql = "SELECT nicno, dateOfBirth FROM nic WHERE nicno = ? AND dateOfBirth = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, nicNumber);
                statement.setString(2, dob);

                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
 
    
    
    
    public int applicationFill(String nic, String nameWithInitials, String fullName, String permanentAddress, String dob, String birthCertificateNo, String birthDistrict, String placeOfBirth, String gender, String age, String profession, String mobileNumber, String email, String birthCertificateDocument, String photoDocument, String nicDocument, String paymentDocument){
        
        int applicationID = -1;
         
   try {
      
       if (!checkExistingNIC(validatedNIC)) {
            // Create SQL statement 
            String sql = "INSERT INTO application (nic, nameWithInitials, fullName, permanentAddress, dateOfBirth, birthCertificateNo, birthCertificateDistrict, placeOfBirth, gender, age, profession, mobileNumber, email, birthCertificateDocument, photoDocument, nicDocument, paymentDocument) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);




            // Set values for parameters 
            statement.setString(1, nic);
            statement.setString(2, nameWithInitials);
            statement.setString(3, fullName);
            statement.setString(4, permanentAddress);
            statement.setString(5, dob);
            statement.setString(6, birthCertificateNo);
            statement.setString(7, birthDistrict);
            statement.setString(8, placeOfBirth);
            statement.setString(9, gender);
            statement.setString(10, age);
            statement.setString(11, profession);
            statement.setString(12, mobileNumber);
            statement.setString(13, email);
            statement.setString(14, birthCertificateDocument);
            statement.setString(15, photoDocument);
            statement.setString(16, nicDocument);
            statement.setString(17, paymentDocument);
            
            



            // Execute the statement 
            int rowsInserted = statement.executeUpdate(); 

            if (rowsInserted > 0) { 
                System.out.println("Data inserted successfully!"); 
            
            // Retrieve the generated registration ID
                var generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    applicationID = generatedKeys.getInt(1);
                }
            }
            else { 
                System.out.println("Data insertion Failed!"); 
            }

            }
       else{
           System.out.println("NIC number already exists!");
       }
   }
            catch(SQLException e) {
                    System.out.println(e);
            }
    
            return applicationID;
    }
    
    
    
    
    private boolean checkExistingNIC(String nicNumber) {
        try {
            String sql = "SELECT COUNT(*) FROM application WHERE nic = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, nicNumber);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
        }
    
    
    
    
    public Applicant(String validatedNIC){
        fetchDataFromDatabase(validatedNIC);
    }    
    
    
    public void fetchDataFromDatabase(String validatedNIC) {
        try {
            
            // Prepare a SQL query to retrieve data
            String query =  "SELECT nameWithInitials, fullName " +
                            "FROM nic " +
                            "WHERE nicno = ?";
            
            
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, validatedNIC);

                // Execute the query
                ResultSet resultSet = statement.executeQuery();

                // Check if there is a result
                if (resultSet.next()) {
                    // Retrieve data from the result set
                    String nameWithInitials = resultSet.getString("nameWithInitials");
                    String fullName = resultSet.getString("fullName");
                    
                    // Set the values to the class members
                    this.nameWithInitials = nameWithInitials;
                    this.fullName = fullName;
                }
            }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public String getNameWithInitials() {
        return nameWithInitials;
    }

    public String getFullName() {
        return fullName;
    }
    
    
    
    
    
    public void ApplicationStatusAndPassportStatus(String applicationID, JTextField policeStatusField, JTextField paymentStatusField, JTextField applicationStatusField, JTextField passportStatusField) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT policeStatus, paymentStatus, applicationStatus, passportStatus FROM application WHERE applicationID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, applicationID);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the values from the result set
                String policeStatusValue = resultSet.getString("policeStatus");
                String paymentStatusValue = resultSet.getString("paymentStatus");
                String applicationStatusValue = resultSet.getString("applicationStatus");
                String passportStatusValue = resultSet.getString("passportStatus");

                // Set the values to the corresponding text fields
                policeStatusField.setText(policeStatusValue);
                paymentStatusField.setText(paymentStatusValue);
                applicationStatusField.setText(applicationStatusValue);
                passportStatusField.setText(passportStatusValue);
                
            } else {
                JOptionPane.showMessageDialog(null, "Application ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
    
    
    
    
    
    public boolean scheduleAppointment(String applicationID, String selectedDate, String selectedTime) {
        PreparedStatement statement = null;

        try {
            if (isDateLimitReached(selectedDate)) {
            JOptionPane.showMessageDialog(null, "You have reached the maximum limit for appointments on this date. Please select another date.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
            }
            String sql = "UPDATE application SET appointmentDate = ?, appointmentTime = ? WHERE applicationID = ?";
            statement = conn.prepareStatement(sql);

            // Set the parameters in the prepared statement
            statement.setString(1, selectedDate);
            statement.setString(2, selectedTime);
            statement.setString(3, applicationID);

            // Execute the update
            int rowsAffected = statement.executeUpdate();

            // Check if the update was successful
            return rowsAffected > 0;
            } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false; // Return false in case of an exception
            }
        
    }
    
    
    
    
    private boolean isDateLimitReached(String selectedDate) {
    try {
        String countQuery = "SELECT COUNT(*) FROM application WHERE appointmentDate = ?";
        try (PreparedStatement countStatement = conn.prepareStatement(countQuery)) {
            countStatement.setString(1, selectedDate);

            try (ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next()) {
                    int appointmentCount = resultSet.getInt(1);
                    return appointmentCount >= 20; // Limit to 20 appointments per date
                }
            }
        }
    }
    catch (SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        return false;
    }
    return false;
    }
    
    
    
    
    
    public void ApplicantReportView(String applicationID, JTextField nic, JTextField nameWithInitials, JTextField fullName, JTextField permanentAddress, JTextField dateOfBirth, JTextField birthCertificateNo, JTextField birthCertificateDistrict, JTextField placeOfBirth, JTextField gender, JTextField age, JTextField profession, JTextField mobileNumber, JTextField email, JTextField policeStatus, JTextField paymentStatus, JTextField applicationStatus, JTextField passportStatus, JTextField appointmentDate, JTextField appointmentTime) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT nic, nameWithInitials, fullName, permanentAddress, dateOfBirth, birthCertificateNo, birthCertificateDistrict, placeOfBirth, gender, age, profession, mobileNumber, email, policeStatus, paymentStatus, applicationStatus, passportStatus, appointmentDate, appointmentTime FROM application WHERE applicationID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, applicationID);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the values from the result set
                String Nic = resultSet.getString("nic");
                String NameWithInitials = resultSet.getString("nameWithInitials");
                String FullName = resultSet.getString("fullName");
                String PermanentAddress = resultSet.getString("permanentAddress");
                String DateOfBirth = resultSet.getString("dateOfBirth");
                String BirthCertificateNo = resultSet.getString("birthCertificateNo");
                String BirthCertificateDistrict = resultSet.getString("birthCertificateDistrict");
                String PlaceOfBirth = resultSet.getString("placeOfBirth");
                String Gender = resultSet.getString("gender");
                String Age = resultSet.getString("age");
                String Profession = resultSet.getString("profession");
                String MobileNumber = resultSet.getString("mobileNumber");
                String Email = resultSet.getString("email");
                String PoliceStatus = resultSet.getString("policeStatus");
                String PaymentStatus = resultSet.getString("paymentStatus");
                String ApplicationStatus = resultSet.getString("applicationStatus");
                String PassportStatus = resultSet.getString("passportStatus");
                String AppointmentDate = resultSet.getString("appointmentDate");
                String AppointmentTime = resultSet.getString("appointmentTime");

                // Set the values to the corresponding text fields
                nic.setText(Nic);
                nameWithInitials.setText(NameWithInitials);
                fullName.setText(FullName);
                permanentAddress.setText(PermanentAddress);
                dateOfBirth.setText(DateOfBirth);
                birthCertificateNo.setText(BirthCertificateNo);
                birthCertificateDistrict.setText(BirthCertificateDistrict);
                placeOfBirth.setText(PlaceOfBirth);
                gender.setText(Gender);
                age.setText(Age);
                profession.setText(Profession);
                mobileNumber.setText(MobileNumber);
                email.setText(Email);
                policeStatus.setText(PoliceStatus);
                paymentStatus.setText(PaymentStatus);
                applicationStatus.setText(ApplicationStatus);
                passportStatus.setText(PassportStatus);
                appointmentDate.setText(AppointmentDate);
                appointmentTime.setText(AppointmentTime);
                
            } else {
                // Handle the case where the applicationID is not found
                JOptionPane.showMessageDialog(null, "Application ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

}
