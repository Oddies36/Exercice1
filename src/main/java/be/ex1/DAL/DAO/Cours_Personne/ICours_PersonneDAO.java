package be.ex1.DAL.DAO.Cours_Personne;

import java.sql.Connection;
import java.util.ArrayList;

public interface ICours_PersonneDAO {

    public void updateCours_personne();

    public void deleteCours_personne();

    public void createCours_personne();

    public ArrayList<Cours_Personne> getCours_personnes();

    public void createTableCours_Personne(Connection conn);

}
