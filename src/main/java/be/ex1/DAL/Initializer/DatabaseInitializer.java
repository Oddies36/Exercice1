package be.ex1.DAL.Initializer;

import java.sql.Connection;
import java.sql.SQLException;

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
    
    public DatabaseInitializer(){
        IStatusDAO istatdao = new StatusDAO();
        IPersonneDAO ipersondao = new PersonneDAO();
        ISectionDAO isecdao = new SectionDAO();
        ICoursDAO icdao = new CoursDAO();
        ICours_PersonneDAO icpdao = new Cours_PersonneDAO();

        DBConnection dbconn = new DBConnection();

        try (Connection conn = dbconn.openConnection("jdbc:postgresql://127.0.0.1/ecole", "postgres", "P642max36+")){
            istatdao.createTableStatus(conn);
            ipersondao.createTablePersonne(conn);
            isecdao.createTableSection(conn);
            icdao.createTableCours(conn);
            icpdao.createTableCours_Personne(conn);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
