package be.ex1.DAL.DAO.Cours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import be.ex1.DAL.Initializer.DBConnection;

public class CoursDAO implements ICoursDAO {
    Connection conn;
    PreparedStatement pstat;

    public CoursDAO(){
        DBConnection.getConnection();
    }

    @Override
    public int getCoursID(String nom) {
        int id = -1;
        String sqlString = "SELECT id FROM Cours WHERE nom = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nom);
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
    public void updateCours(int id, String nom) {
        String sqlString = "UPDATE Cours SET nom = ? WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(2, id);
            pstat.setString(1, nom);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCours(int id) {
        String sqlString = "DELETE FROM Cours WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(1, id);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createCours(String nomSection, String nom) {
        String sqlString = "INSERT INTO Cours (id_section, nom) VALUES ((SELECT id FROM Section WHERE nom = ?), ?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nomSection);
            pstat.setString(2, nom);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Cours> getCours() {
        String sqlString = "SELECT id, id_section, nom FROM Cours";
        ArrayList<Cours> coursAL = new ArrayList<Cours>();

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    Cours cou = new Cours(rset.getInt(1), rset.getInt(2), rset.getString(3));
                    coursAL.add(cou);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return coursAL;
    }

    @Override
    public void createTableCours() {
        String sqlString = "CREATE TABLE IF NOT EXISTS Cours (id SERIAL PRIMARY KEY, id_section INT, nom VARCHAR(30), FOREIGN KEY (id_section) REFERENCES Section(id))";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
