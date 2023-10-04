package be.ex1.DAL.DAO.Cours;

import java.sql.Connection;
import java.util.ArrayList;

public interface ICoursDAO {

    public void getCoursID();

    public void updateCours();

    public void deleteCours();

    public void createCours();

    public ArrayList<Cours> getCours();

    public void createTableCours(Connection conn);

}
