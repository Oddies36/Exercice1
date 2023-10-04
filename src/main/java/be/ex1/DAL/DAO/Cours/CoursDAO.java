package be.ex1.DAL.DAO.Cours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoursDAO implements ICoursDAO {
    Connection conn;
    PreparedStatement pstat;

    public CoursDAO(){

    }
    @Override
    public void getCoursID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoursID'");
    }

    @Override
    public void updateCours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCours'");
    }

    @Override
    public void deleteCours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCours'");
    }

    @Override
    public void createCours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCours'");
    }

    @Override
    public ArrayList<Cours> getCours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCours'");
    }
    @Override
    public void createTableCours(Connection conn) {
        String sqlString = "CREATE TABLE IF NOT EXISTS Cours (id SERIAL PRIMARY KEY, id_section INT, nom VARCHAR(30), FOREIGN KEY (id_section) REFERENCES Section(id))";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
