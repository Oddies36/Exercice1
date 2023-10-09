package be.ex1.DAL.DAO.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectionDAO implements ISectionDAO {

    @Override
    public int getSectionID(Connection conn, String section) {
        int id = -1;
        String sqlString = "SELECT id FROM Section WHERE nom = ?";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.setString(1, section);
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
    public void updateSection(Connection conn, int id, String section) {
        String sqlString = "UPDATE Section SET nom = ? WHERE id = ?";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.setInt(2, id);
            pstat.setString(1, section);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSection(Connection conn, int id) {
        String sqlString = "DELETE FROM Section WHERE id = ?";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.setInt(1, id);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createSection(Connection conn, String section) {
        String sqlString = "INSERT INTO Section (nom) VALUES (?)";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.setString(1, section);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Section> getSections(Connection conn) {
        String sqlString = "SELECT id, nom FROM section";
        ArrayList<Section> secAL = new ArrayList<Section>();

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    Section sec = new Section(rset.getInt(1), rset.getString(2));
                    secAL.add(sec);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return secAL;
    }

    @Override
    public void createTableSection(Connection conn) {
        String sqlString = "CREATE TABLE IF NOT EXISTS Section (id SERIAL PRIMARY KEY, nom VARCHAR(30))";
        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
