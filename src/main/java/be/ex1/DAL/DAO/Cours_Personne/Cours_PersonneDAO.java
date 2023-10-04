package be.ex1.DAL.DAO.Cours_Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cours_PersonneDAO implements ICours_PersonneDAO {

    @Override
    public void updateCours_personne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCours_personne'");
    }

    @Override
    public void deleteCours_personne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCours_personne'");
    }

    @Override
    public void createCours_personne() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCours_personne'");
    }

    @Override
    public ArrayList<Cours_Personne> getCours_personnes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCours_personnes'");
    }

    @Override
    public void createTableCours_Personne(Connection conn) {
        String sqlString = "CREATE TABLE IF NOT EXISTS Cours_Personne (id_personne INT, id_cours INT, annee INT, FOREIGN KEY (id_personne) REFERENCES Personne(id), FOREIGN KEY (id_cours) REFERENCES Cours(id), PRIMARY KEY (id_personne, id_cours, annee))";

        try(PreparedStatement pstat = conn.prepareStatement(sqlString)){
            pstat.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
