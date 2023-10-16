package be.ex1.DAL.Initializer;

import be.ex1.DAL.DAO.Cours.CoursDAO;
import be.ex1.DAL.DAO.Cours.ICoursDAO;
import be.ex1.DAL.DAO.Cours_Personne.Cours_PersonneDAO;
import be.ex1.DAL.DAO.Cours_Personne.ICours_PersonneDAO;
import be.ex1.DAL.DAO.Personne.IPersonneDAO;
import be.ex1.DAL.DAO.Personne.PersonneDAO;
import be.ex1.DAL.DAO.Section.ISectionDAO;
import be.ex1.DAL.DAO.Section.SectionDAO;
import be.ex1.DAL.DAO.Status.IStatusDAO;
import be.ex1.DAL.DAO.Status.StatusDAO;

public class DatabaseInitializer {
    
    public static void createAllTables(){
        DBConnection.getConnection();

        IStatusDAO istatdao = new StatusDAO();
        IPersonneDAO ipersondao = new PersonneDAO();
        ISectionDAO isecdao = new SectionDAO();
        ICoursDAO icdao = new CoursDAO();
        ICours_PersonneDAO icpdao = new Cours_PersonneDAO();

        istatdao.createTableStatus();
        ipersondao.createTablePersonne();
        isecdao.createTableSection();
        icdao.createTableCours();
        icpdao.createTableCours_Personne();
    }

}
