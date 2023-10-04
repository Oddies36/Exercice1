package be.ex1.DAL.DAO.Section;

import java.sql.Connection;
import java.util.ArrayList;

public interface ISectionDAO {

    public void getSectionID();

    public void updateSection();

    public void deleteSection();

    public void createSection();

    public ArrayList<Section> getSections();

    public void createTableSection(Connection conn);
}
