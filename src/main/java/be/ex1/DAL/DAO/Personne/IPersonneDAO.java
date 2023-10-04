package be.ex1.DAL.DAO.Personne;

import java.sql.Connection;
import java.util.ArrayList;

public interface IPersonneDAO {

    public void getPersonneID();

    public void updatePersonne();

    public void deletePersonne();

    public void createPersonne();

    public ArrayList<Personne> getPersonnes();

    public void createTablePersonne(Connection conn);
    
}
