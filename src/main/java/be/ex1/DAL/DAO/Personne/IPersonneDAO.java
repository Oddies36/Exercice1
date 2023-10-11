package be.ex1.DAL.DAO.Personne;

import java.util.ArrayList;

public interface IPersonneDAO {

    public int getPersonneID(String nom, String prenom);

    public void updatePersonne(String nom, String prenom, int id);

    public void deletePersonne(int id);

    public void createPersonne(String nomStatus, String nom, String prenom);

    public ArrayList<Personne> getPersonnes();

    public void createTablePersonne();
    
}
