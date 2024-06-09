/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passportautomationsystem;
import java.sql.*;
/**
 *
 * @author User
 */
public class PASDBConnection {
    private String username;
    private String password;
    private String hostname;
    private String dbname;
    
    public PASDBConnection(){
        this.username = "root";
        this.password = "Lnbti#12";
        this.hostname = "localhost";
        this.dbname = "passportSystem";
    }
    
    public Connection dbconnection(){
        Connection conn = null;
   
        try {
            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/passportSystem", "root", "Lnbti#12");
            return conn;
        }
        catch (SQLException e) {
            return conn;
        }
    }
    
}
