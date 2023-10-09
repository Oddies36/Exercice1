package be.ex1.DAL.DAO.Personne;

import java.sql.Connection;
import java.util.ArrayList;

public interface IPersonneDAO {

    public int getPersonneID(Connection conn, String nom, String prenom);

    public void updatePersonne(Connection conn, String nom, String prenom, int id);

    public void deletePersonne(Connection conn, int id);

    public void createPersonne(Connection conn, int statusId, String nom, String prenom);

    public ArrayList<Personne> getPersonnes(Connection conn);

    public void createTablePersonne(Connection conn);
    
}
