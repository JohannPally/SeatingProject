package model;

import java.util.HashMap;
import java.util.List;

public class RFloor implements Floor{

    private HashMap<Integer, Table> tables;
    private HashMap<String, Section> sections;
    private List<Section> nextToSeat;
    private List<Table> unassigned;

    public RFloor(){
    }

    @Override
    public void addTable(Table tab) {
        //likely have to send something to view
        tables.put(tab.getTableNum(), tab);
        unassigned.add(tab);
    }

    public void addSection(Section sec) {
        //likely have to send something to view
        nextToSeat.add(sec);
        sections.put(sec.getName(), sec);
    }

    @Override
    public Table getTable(int tnum) {
        Table t =tables.get(tnum);
        if (!t.equals(null))
            return t;
        return new ErrorTable();
    }

    @Override
    public Section getSection(String name) {
        //might consider returning list of sections if multiple with name like Stella, Stella/Daniel/Nick
        return null;
    }

    //need to decide whether I should seat the party here or within the section? Probably here since some may not have
    //a section yet?
    @Override
    public void seat(Table tab, Party par) {
        tab.seat(par);
        tab.getSection().seatTable(tab);
    }

    @Override
    public void unseat(Table tab) {
        tab.getSection().unseatTable(tab);
        tab.unseat();
    }

    @Override
    public void finish(Table tab) {
        tab.getSection().finishTable(tab);
    }

    @Override
    public void assignSection(Table tab, Section sec) {
        unassigned.remove(tab);
        sec.assignTable(tab);
    }

    @Override
    public void unassignSection(Table tab){
        if(tab.isSectioned()){
            tab.unsetSection();
            tab.getSection().unassignTable(tab);
        }
    }

    @Override
    public List<Table> getUnassignedTables(){
        return unassigned;
    }

    @Override
    public void moveTable(Table fromT, Table toT, Section toS) {
        fromT.getSection().unassignTable(fromT);
        Party temppar = fromT.getParty();
        fromT.unseat();

        toT.setSection(toS);
        toT.seat(temppar);
        toS.assignTable(toT);
    }

    @Override
    public void blockTable() {

    }

    @Override
    public void unblockTable() {

    }

    @Override
    public void blockServer() {

    }

    @Override
    public void unblockServer() {

    }
}
