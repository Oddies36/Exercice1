package be.ex1.DAL.DAO.Section;

public class Section {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Section(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
