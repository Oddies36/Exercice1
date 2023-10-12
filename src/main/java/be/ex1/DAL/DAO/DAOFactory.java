package be.ex1.DAL.DAO;

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
import be.ex1.DAL.Initializer.DBConnection;

public class DAOFactory {
    
    public DAOFactory(){
        DBConnection.getConnection();
    }

    public ISectionDAO createSectionDAO(){
        return new SectionDAO();
    }

    public IStatusDAO createStatusDAO(){
        return new StatusDAO();
    }

    public IPersonneDAO createPersonneDAO(){
        return new PersonneDAO();
    }

    public ICours_PersonneDAO createCours_PersonneDAO(){
        return new Cours_PersonneDAO();
    }

    public ICoursDAO createCoursDAO(){
        return new CoursDAO();
    }
}
