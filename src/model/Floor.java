package model;

import java.util.List;

public interface Floor {
    public void addTable(Table tab);
    public void addSection(Section sec);

    public Table getTable(int tnum);
    public Section getSection(String name);

    public void seat(Table tab, Party par);
    public void unseat(Table tab);
    public void finish(Table tab);
    public void assignSection(Table tab, Section ser);
    public void unassignSection(Table tab);

    public List<Table> getUnassignedTables();
    public void moveTable(Table fromT, Table toT, Section toS);

    public void blockTable();
    public void unblockTable();
    public void blockServer();
    public void unblockServer();
}
