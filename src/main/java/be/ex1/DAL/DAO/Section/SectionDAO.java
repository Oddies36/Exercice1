package be.ex1.DAL.DAO.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectionDAO implements ISectionDAO {

    @Override
    public void getSectionID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSectionID'");
    }

    @Override
    public void updateSection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSection'");
    }

    @Override
    public void deleteSection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSection'");
    }

    @Override
    public void createSection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSection'");
    }

    @Override
    public ArrayList<Section> getSections() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSections'");
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
