package be.ex1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import be.ex1.DAL.DAO.Cours.CoursDAO;
import be.ex1.DAL.DAO.Cours.ICoursDAO;
import be.ex1.DAL.DAO.Cours_Personne.Cours_PersonneDAO;
import be.ex1.DAL.DAO.Cours_Personne.ICours_PersonneDAO;
import be.ex1.DAL.DAO.Personne.IPersonneDAO;
import be.ex1.DAL.DAO.Personne.Personne;
import be.ex1.DAL.DAO.Personne.PersonneDAO;
import be.ex1.DAL.DAO.Section.ISectionDAO;
import be.ex1.DAL.DAO.Section.Section;
import be.ex1.DAL.DAO.Section.SectionDAO;
import be.ex1.DAL.DAO.Status.IStatusDAO;
import be.ex1.DAL.DAO.Status.Status;
import be.ex1.DAL.DAO.Status.StatusDAO;
import be.ex1.DAL.Initializer.DBConnection;
import be.ex1.DAL.Initializer.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitializer();
        DBConnection.getConnection();

        IStatusDAO istatdao = new StatusDAO();
        ISectionDAO isecdao = new SectionDAO();
        IPersonneDAO ipersdao = new PersonneDAO();
        ICours_PersonneDAO icourPersdao = new Cours_PersonneDAO();
        ICoursDAO icourdao = new CoursDAO();

        istatdao.createStatus("Etudiant");
        istatdao.createStatus("Charge de cours");
        istatdao.createStatus("Employe administratif");
        
        isecdao.createSection("Informatique de gestion");
        isecdao.createSection("Droit");
        
        ipersdao.createPersonne("Charge de cours", "Poulet", "Gilles");
        ipersdao.createPersonne("Charge de cours", "Godissart", "Emmanuel");
        ipersdao.createPersonne("Employe administratif", "Lai", "Valeria");
        ipersdao.createPersonne("Employe administratif", "Mairesse", "David");
        ipersdao.createPersonne("Etudiant", "Durant", "Richard");
        ipersdao.createPersonne("Etudiant", "Ortiz", "Valerie");

        icourdao.createCours("Informatique de gestion", "Base de réseaux");
        icourdao.createCours("Informatique de gestion", "Systèmes d'exploitation");
        icourdao.createCours("Informatique de gestion", "Programmation orienté objet");
        icourdao.createCours("Droit", "Droit civil");
        icourdao.createCours("Droit", "Droit commercial");
        
        icourPersdao.createCours_personne("Poulet", "Gilles", "Systèmes d'exploitation", 2022);
        icourPersdao.createCours_personne("Godissart", "Emmanuel", "Base de réseaux", 2023);
        icourPersdao.createCours_personne("Durant", "Richard", "Systèmes d'exploitation", 2021);
        icourPersdao.createCours_personne("Durant", "Richard", "Base de réseaux", 2020);

        DBConnection.closeConnection();

    }
}