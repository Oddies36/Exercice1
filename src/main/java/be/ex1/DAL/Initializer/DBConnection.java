package be.ex1.DAL.Initializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public DBConnection(){
        
    }

    public Connection openConnection(String url, String username, String password){
        try{
            return DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
