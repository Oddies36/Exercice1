package be.ex1;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

        DBConnection dbconn = new DBConnection();
        IStatusDAO istatdao = new StatusDAO();
        ISectionDAO isecdao = new SectionDAO();
        IPersonneDAO ipersdao = new PersonneDAO();

        ArrayList<Personne> alist = new ArrayList<Personne>();
        int id = -1;

        try(Connection conn = dbconn.openConnection("jdbc:postgresql://127.0.0.1/ecole", "postgres", "P642max36+")){
            //istatdao.createStatus(conn, "Etudiant");
            //istatdao.createStatus(conn, "Charge de cours");
            //istatdao.createStatus(conn, "Employe administratif");

            //isecdao.createSection(conn, "Informatique de gestion");
            //isecdao.createSection(conn, "Droit");

            //isecdao.deleteSection(conn, 2);
            
            //istatdao.deleteStatus(conn, 1);
            //istatdao.deleteStatus(conn, 2);
            //istatdao.deleteStatus(conn, 4);

            //istatdao.updateStatus(conn, 7, "Employe Administratif");

            //ipersdao.createPersonne(conn, 6, "Poulet", "Gilles");
            //ipersdao.createPersonne(conn, 6, "Godissart", "Emmanuel");
            //ipersdao.createPersonne(conn, 7, "Lai", "Valeria");
            //ipersdao.createPersonne(conn, 7, "Mairesse", "David");
            //ipersdao.createPersonne(conn, 5, "Durant", "Richard");
            //ipersdao.createPersonne(conn, 5, "Ortiz", "Valerie");

            id = ipersdao.getPersonneID(conn, "Lai", "Valeria");
            System.out.println(id);

            alist = ipersdao.getPersonnes(conn);
            for (Personne p : alist){
                System.out.println(p.getId() + " " + p.getId_status() + " " + p.getNom() + " " + p.getPrenom());
            }

            

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
}