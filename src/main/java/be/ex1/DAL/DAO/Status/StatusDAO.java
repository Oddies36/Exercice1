package be.ex1.DAL.DAO.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatusDAO implements IStatusDAO {

    public StatusDAO(){}
    @Override
    public void getStatusID(Connection conn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatusID'");
    }

    @Override
    public void updateStatus(Connection conn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStatus'");
    }

    @Override
    public void deleteStatus(Connection conn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStatus'");
    }

    @Override
    public void createStatus(Connection conn, String status) {
        String sqlString = "INSERT INTO Status (status) VALUES (?)";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.setString(1, status);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Status> getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    @Override
    public void createTableStatus(Connection conn) {
        String sqlString = "CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, status VARCHAR(20))";

        try (PreparedStatement pstat = conn.prepareStatement(sqlString)) {
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
