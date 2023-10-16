package be.ex1.DAL.Initializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection conn;
    private static DBConnection instance;

    public DBConnection(){
        try{
            DBConnection.conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/ecole", "postgres", "test123");
            System.out.println("Connection ok");
        }    
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static DBConnection getConnection(){
        if(DBConnection.instance == null){
            DBConnection.instance = new DBConnection();
        }
        return DBConnection.instance;
    }

    public static void closeConnection(){
        try{
            if(DBConnection.conn != null){
                DBConnection.conn.close();
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
