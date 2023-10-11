package be.ex1.DAL.DAO.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.ex1.DAL.Initializer.DBConnection;

public class StatusDAO implements IStatusDAO {

    public StatusDAO(){
        DBConnection.getConnection();
    }

    @Override
    public int getStatusID(String status) {
        int id = -1;
        String sqlString = "SELECT id FROM Status WHERE status = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, status);
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
    public void updateStatus(int id, String status) {
        String sqlString = "UPDATE Status SET status = ? WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(2, id);
            pstat.setString(1, status);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStatus(int id) {
        String sqlString = "DELETE FROM Status WHERE id = ?";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(1, id);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createStatus(String status) {
        String sqlString = "INSERT INTO Status (status) VALUES (?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, status);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Status> getStatus() {
        String sqlString = "SELECT id, status FROM status";
        ArrayList<Status> statAL = new ArrayList<Status>();

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    Status stat = new Status(rset.getInt(1), rset.getString(2));
                    statAL.add(stat);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return statAL;
    }

    @Override
    public void createTableStatus() {
        String sqlString = "CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, status VARCHAR(30))";

        try (PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)) {
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
