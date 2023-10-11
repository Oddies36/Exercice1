package be.ex1.DAL.DAO.Section;

import java.util.ArrayList;

public interface ISectionDAO {

    public int getSectionID(String section);

    public void updateSection(int id, String section);

    public void deleteSection(int id);

    public void createSection(String section);

    public ArrayList<Section> getSections();

    public void createTableSection();
}
