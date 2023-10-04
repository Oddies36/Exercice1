package be.ex1.DAL.DAO.Status;

import java.sql.Connection;
import java.util.ArrayList;

public interface IStatusDAO {

    public void getStatusID(Connection conn);

    public void updateStatus(Connection conn);

    public void deleteStatus(Connection conn);

    public void createStatus(Connection conn, String status);

    public ArrayList<Status> getStatus();

    public void createTableStatus(Connection conn);
}
