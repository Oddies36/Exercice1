package be.ex1.DAL.DAO.Status;

import java.util.ArrayList;

public interface IStatusDAO {

    public int getStatusID(String status);

    public void updateStatus(int id, String status);

    public void deleteStatus(int id);

    public void createStatus(String status);

    public ArrayList<Status> getStatus();

    public void createTableStatus();
}
