package be.ex1;

import be.ex1.DAL.DAO.DAOFactory;
import be.ex1.DAL.DAO.Cours.ICoursDAO;
import be.ex1.DAL.DAO.Cours_Personne.ICours_PersonneDAO;
import be.ex1.DAL.DAO.Personne.IPersonneDAO;
import be.ex1.DAL.DAO.Section.ISectionDAO;
import be.ex1.DAL.DAO.Status.IStatusDAO;
import be.ex1.DAL.Initializer.DBConnection;
import be.ex1.DAL.Initializer.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitializer();

/*         DAOFactory factory = new DAOFactory();

        IStatusDAO istatdao = factory.createStatusDAO();
        ISectionDAO isecdao = factory.createSectionDAO();
        IPersonneDAO ipersdao = factory.createPersonneDAO();
        ICours_PersonneDAO icourPersdao = factory.createCours_PersonneDAO();
        ICoursDAO icourdao = factory.createCoursDAO();

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
        icourPersdao.createCours_personne("Durant", "Richard", "Base de réseaux", 2020); */

        DBConnection.closeConnection();

    }
}