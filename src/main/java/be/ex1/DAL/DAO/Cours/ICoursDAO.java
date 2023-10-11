package be.ex1.DAL.DAO.Cours;

import java.util.ArrayList;

public interface ICoursDAO {

    public int getCoursID(String nom);

    public void updateCours(int id, String nom);

    public void deleteCours(int id);

    public void createCours(String nomSection, String nom);

    public ArrayList<Cours> getCours();

    public void createTableCours();

}
