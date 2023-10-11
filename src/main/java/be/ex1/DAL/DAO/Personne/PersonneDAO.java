package be.ex1.DAL.DAO.Personne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ex1.DAL.Initializer.DBConnection;

public class PersonneDAO implements IPersonneDAO {

    @Override
    public int getPersonneID(String nom, String prenom) {
        int id = -1;
        String sqlString = "SELECT id FROM Personne WHERE nom = ? AND prenom = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nom);
            pstat.setString(2, prenom);
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    id = rset.getInt(1);
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void updatePersonne(String nom, String prenom, int id) {
        String sqlString = "UPDATE Personne SET nom = ?, prenom = ? WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nom);
            pstat.setString(2, prenom);
            pstat.setInt(3, id);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletePersonne(int id) {
        String sqlString = "DELETE FROM Personne WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(1, id);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createPersonne(String nomStatus, String nom, String prenom) {
        String sqlString = "INSERT INTO Personne (id_status, nom, prenom) VALUES ((SELECT id FROM Status WHERE status = ?), ?, ?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nomStatus);
            pstat.setString(2, nom);
            pstat.setString(3, prenom);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Personne> getPersonnes() {
        String sqlString = "SELECT id, id_status, nom, prenom FROM Personne";
        ArrayList<Personne> persAL = new ArrayList<Personne>();

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    Personne pers = new Personne(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4));
                    persAL.add(pers);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return persAL;
    }

    @Override
    public void createTablePersonne() {
        String sqlString = "CREATE TABLE IF NOT EXISTS Personne (id SERIAL PRIMARY KEY, id_status INT, nom VARCHAR(15), prenom VARCHAR(15), FOREIGN KEY(id_status) REFERENCES status(id))";
        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)) {
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
