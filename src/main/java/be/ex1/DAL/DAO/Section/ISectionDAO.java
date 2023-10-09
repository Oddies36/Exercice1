package be.ex1.DAL.DAO.Section;

import java.sql.Connection;
import java.util.ArrayList;

public interface ISectionDAO {

    public int getSectionID(Connection conn, String section);

    public void updateSection(Connection conn, int id, String section);

    public void deleteSection(Connection conn, int id);

    public void createSection(Connection conn, String section);

    public ArrayList<Section> getSections(Connection conn);

    public void createTableSection(Connection conn);
}
