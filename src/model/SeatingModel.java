package model;

public class SeatingModel {
    private RFloor floor;

    public SeatingModel()
    {
        floor = new RFloor();
    }

    public void makeSection(String name){
        Section sec = new RSection(name);
        floor.addSection(sec);
    }

    public void makeTable(int t, int s){
        Table tab = new RTable(t, s);
        floor.addTable(tab);
    }
}
