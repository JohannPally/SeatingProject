package model;

import java.util.List;

public interface Section {
    public String getName();
    public int getShiftCovers();
    public int getShiftTops();

    public List<Table> getTables();
    public boolean isInSection(Table tab);
    public List<Table> getVacant();
    public List<Table>  getSeated();

    public void assignTable(Table tab);
    public void unassignTable(Table tab);
    public void finishTable(Table tab);
    public void seatTable(Table tab);
    public void unseatTable(Table tab);
}
