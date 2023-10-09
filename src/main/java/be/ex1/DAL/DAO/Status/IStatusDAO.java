package be.ex1.DAL.DAO.Status;

import java.sql.Connection;
import java.util.ArrayList;

public interface IStatusDAO {

    public int getStatusID(Connection conn, String status);

    public void updateStatus(Connection conn, int id, String status);

    public void deleteStatus(Connection conn, int id);

    public void createStatus(Connection conn, String status);

    public ArrayList<Status> getStatus(Connection conn);

    public void createTableStatus(Connection conn);
}
