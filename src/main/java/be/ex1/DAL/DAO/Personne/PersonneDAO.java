package be.ex1.DAL.DAO.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonneDAO implements IPersonneDAO {

    @Override
    public void getPersonneID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonneID'");
    }

    @Override
    public void updatePersonne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePersonne'");
    }

    @Override
    public void deletePersonne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePersonne'");
    }

    @Override
    public void createPersonne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPersonne'");
    }

    @Override
    public ArrayList<Personne> getPersonnes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonnes'");
    }

    @Override
    public void createTablePersonne(Connection conn) {
        String sqlString = "CREATE TABLE IF NOT EXISTS Personne (id SERIAL PRIMARY KEY, id_status INT, nom VARCHAR(15), prenom VARCHAR(15), FOREIGN KEY(id_status) REFERENCES status(id))";
        try(PreparedStatement pstat = conn.prepareStatement(sqlString)) {
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
