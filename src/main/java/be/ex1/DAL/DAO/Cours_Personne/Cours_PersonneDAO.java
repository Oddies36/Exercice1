package be.ex1.DAL.DAO.Cours_Personne;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import be.ex1.DAL.Initializer.DBConnection;

public class Cours_PersonneDAO implements ICours_PersonneDAO {

    public Cours_PersonneDAO(){
        DBConnection.getConnection();
    }
    
    @Override
    public void updateCours_personne(int annee, String nomPersonne, String prenomPersonne, String nomCours) {
        String sqlString = "UPDATE Cours_Personne SET annee = ? WHERE id_personne = (SELECT id FROM Personne WHERE nom = ? AND prenom = ?) AND id_cours = (SELECT id FROM Cours WHERE nom = ?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(1, annee);
            pstat.setString(2, nomPersonne);
            pstat.setString(3, prenomPersonne);
            pstat.setString(4, nomCours);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteCours_personne(int annee, String nomPersonne, String prenomPersonne, String nomCours) {
        String sqlString = "DELETE FROM Cours_Personne WHERE annee = ? AND id_personne = (SELECT id FROM Personne WHERE nom = ? AND prenom = ?) AND id_cours = (SELECT id FROM Cours WHERE nom = ?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setInt(1, annee);
            pstat.setString(2, nomPersonne);
            pstat.setString(3, prenomPersonne);
            pstat.setString(4, nomCours);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createCours_personne(String nomPersonne, String prenomPersonne, String nomCours, int annee) {
        String sqlString = "INSERT INTO Cours_Personne (id_personne, id_cours, annee) VALUES ( (SELECT id FROM Personne WHERE nom = ? AND prenom = ?), (SELECT id FROM cours WHERE nom = ?), ?)";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.setString(1, nomPersonne);
            pstat.setString(2, prenomPersonne);
            pstat.setString(3, nomCours);
            pstat.setInt(4, annee);
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Cours_Personne> getCours_personnes() {
        String sqlString = "SELECT id_personne, id_cours, annee FROM Cours_personne";
        ArrayList<Cours_Personne> courPersAL = new ArrayList<Cours_Personne>();

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            try(ResultSet rset = pstat.executeQuery()){
                while(rset.next()){
                    Cours_Personne courPers = new Cours_Personne(rset.getInt(1), rset.getInt(2), rset.getInt(3));
                    courPersAL.add(courPers);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return courPersAL;
    }

    @Override
    public void createTableCours_Personne() {
        String sqlString = "CREATE TABLE IF NOT EXISTS Cours_Personne (id_personne INT, id_cours INT, annee INT, FOREIGN KEY (id_personne) REFERENCES Personne(id), FOREIGN KEY (id_cours) REFERENCES Cours(id), PRIMARY KEY (id_personne, id_cours, annee))";

        try(PreparedStatement pstat = DBConnection.conn.prepareStatement(sqlString)){
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
