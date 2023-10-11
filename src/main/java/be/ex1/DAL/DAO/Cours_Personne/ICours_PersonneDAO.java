package be.ex1.DAL.DAO.Cours_Personne;

import java.util.ArrayList;

public interface ICours_PersonneDAO {

    public void updateCours_personne(int annee, String nomPersonne, String prenomPersonne, String nomCours);

    public void deleteCours_personne(int annee, String nomPersonne, String prenomPersonne, String nomCours);

    public void createCours_personne(String nomPersonne, String prenomPersonne, String nomCours, int annee);

    public ArrayList<Cours_Personne> getCours_personnes();

    public void createTableCours_Personne();

}
