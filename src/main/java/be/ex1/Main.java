package be.ex1;


import java.sql.Connection;
import java.sql.SQLException;

import be.ex1.DAL.DAO.Status.IStatusDAO;
import be.ex1.DAL.DAO.Status.StatusDAO;
import be.ex1.DAL.Initializer.DBConnection;
import be.ex1.DAL.Initializer.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitializer();

        DBConnection dbconn = new DBConnection();
        IStatusDAO istatdao = new StatusDAO();

        try(Connection conn = dbconn.openConnection("jdbc:postgresql://127.0.0.1/ecole", "postgres", "P642max36+")){
            istatdao.createStatus(conn, "Etudiant");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}